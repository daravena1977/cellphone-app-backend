package com.diegoaravena.cellphoneserviceapp.controllers;

import com.diegoaravena.cellphoneserviceapp.dtos.NewWorkorderDTO;
import com.diegoaravena.cellphoneserviceapp.dtos.WorkorderDTO;
import com.diegoaravena.cellphoneserviceapp.models.enums.StateOrder;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.RepairCellphone;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Workorder;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.WorkorderRepairCellphone;
import com.diegoaravena.cellphoneserviceapp.models.subclass.Client;
import com.diegoaravena.cellphoneserviceapp.repositories.ClientRepository;
import com.diegoaravena.cellphoneserviceapp.repositories.RepairCellphoneRepository;
import com.diegoaravena.cellphoneserviceapp.repositories.WorkorderRepairCellphoneRepository;
import com.diegoaravena.cellphoneserviceapp.repositories.WorkorderRepository;
import com.diegoaravena.cellphoneserviceapp.services.WorkOrderService;
import org.hibernate.ObjectDeletedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class WorkorderController {

    @Autowired
    private WorkorderRepository workorderRepository;

    @Autowired
    private WorkOrderService workOrderService;

    @Autowired
    private ClientRepository  clientRepository;

    @Autowired
    private RepairCellphoneRepository repairCellphoneRepository;

    @Autowired
    private WorkorderRepairCellphoneRepository workorderRepairCellphoneRepository;

    @GetMapping("/workorders")
    public List<WorkorderDTO> getWorkordersDTO(){
        return workorderRepository
                .findAll()
                .stream()
                .map(WorkorderDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/workorders/status")
    public List<WorkorderDTO> getWorkordersPending(@RequestParam StateOrder stateOrder){
        return workorderRepository
                .findByStateOrder(stateOrder)
                .stream()
                .map(WorkorderDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @PostMapping("/workorders/client-exists")
    public ResponseEntity<Object> addWorkOrderClientsExists(@RequestBody NewWorkorderDTO newWorkorderDTO) {
        Client client = clientRepository.findByDni(newWorkorderDTO.getDni());

        if (client == null) {
            return new ResponseEntity<>("El cliente no existe en la base de datos", HttpStatus.NOT_FOUND);
        }

        Workorder workorder = new Workorder(newWorkorderDTO.getNumber(), newWorkorderDTO.getCreationDate(),
                newWorkorderDTO.getDeliverDate(), newWorkorderDTO.getDescription(), newWorkorderDTO.getStateOrder());

        workorder.setClient(client);

        workorderRepository.save(workorder);

        newWorkorderDTO.getRepairCellphones().forEach(repair -> {
            RepairCellphone repairCellphone = repairCellphoneRepository.findById(repair.getId()).orElse(null);

            assert repairCellphone != null;
            WorkorderRepairCellphone workorderRepairCellphone = new WorkorderRepairCellphone(repairCellphone.getPrice());

            workorderRepairCellphone.setWorkOrder(workorder);
            workorderRepairCellphone.setRepairCellphone(repairCellphone);
            workorder.addRepair(workorderRepairCellphone);
            workorderRepairCellphoneRepository.save(workorderRepairCellphone);


        });

        return new ResponseEntity<>("Work order was created successfully", HttpStatus.CREATED);

    }


    @Transactional
    @PostMapping("/workorders")
    public ResponseEntity<Object> createWorkOrder(@RequestBody NewWorkorderDTO newWorkorderDTO){

        if (clientRepository.existsByDni(newWorkorderDTO.getDni())){
            return new ResponseEntity<>("El cliente ya existe en el sistema", HttpStatus.FORBIDDEN);
        }

        if (clientRepository.existsByEmail(newWorkorderDTO.getEmail())){
            return new ResponseEntity<>("This email is already in use!", HttpStatus.FORBIDDEN);
        }

        if (newWorkorderDTO.getNumber().toString().isBlank()){
            return new ResponseEntity<>("The number data is missing", HttpStatus.FORBIDDEN);
        }

        if (newWorkorderDTO.getCreationDate().isBefore(LocalDate.now())){
            return new ResponseEntity<>("This date is not the actual date", HttpStatus.FORBIDDEN);
        }

        if (workorderRepository.existsByNumber(newWorkorderDTO.getNumber()) &&
                workorderRepository.existsByCreationDate(newWorkorderDTO.getCreationDate().getYear())){
            return new ResponseEntity<>("This work order already exists", HttpStatus.FORBIDDEN);
        }

        Client client = new Client(newWorkorderDTO.getDni(), newWorkorderDTO.getFirstName(), newWorkorderDTO.getLastName(),
                newWorkorderDTO.getEmail(), newWorkorderDTO.getPhoneNumber(), newWorkorderDTO.getAddress());

        Workorder workorder = new Workorder(newWorkorderDTO.getNumber(), newWorkorderDTO.getCreationDate(),
                newWorkorderDTO.getDeliverDate(), newWorkorderDTO.getDescription(), newWorkorderDTO.getStateOrder());

        clientRepository.save(client);

        workorder.setClient(client);

        workorderRepository.save(workorder);

        newWorkorderDTO.getRepairCellphones().forEach(repair -> {
            RepairCellphone repairCellphone = repairCellphoneRepository.findById(repair.getId()).orElse(null);

            assert repairCellphone != null;
            WorkorderRepairCellphone workorderRepairCellphone = new WorkorderRepairCellphone(repairCellphone.getPrice());

            workorderRepairCellphone.setWorkOrder(workorder);
            workorderRepairCellphone.setRepairCellphone(repairCellphone);
            workorder.addRepair(workorderRepairCellphone);
            workorderRepairCellphoneRepository.save(workorderRepairCellphone);


        });

        return new ResponseEntity<>("Work order was created successfully", HttpStatus.CREATED);

    }

    @GetMapping("/workorders/all-by-number")
    public ResponseEntity<Object> findAllByNumber(@RequestParam("number") Integer number) {
         Set<WorkorderDTO> workorderDTOS = workOrderService.findAllWorkOrdersByNumber(number);

         if (workorderDTOS == null) {
             return new  ResponseEntity<>("No se encontro orden de trabajo", HttpStatus.FORBIDDEN);
         }

         return ResponseEntity.ok().body(workorderDTOS);

    }

    @GetMapping("/workorders/find-by-date")
    public ResponseEntity<Object> findByDate(@RequestParam("startDateStr") String startDateStr,
                                             @RequestParam("endDateStr") String endDateStr) {

        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        if (startDate.isAfter(endDate)) {
            return new ResponseEntity<>("La fecha desde debe ser anterior a fecha hasta", HttpStatus.FORBIDDEN);
        }

        Set<WorkorderDTO> workorderDTOS = workOrderService.findAllWorkOrdersByDate(startDate, endDate);

        return ResponseEntity.ok().body(workorderDTOS);
    }

    @GetMapping("/workorders/find-by-state")
    public ResponseEntity<Object> findByState(@RequestParam StateOrder stateOrder) {
        Set<WorkorderDTO> workorderDTOS = workOrderService.findAllWorkOrdersByState(stateOrder);

        return ResponseEntity.ok().body(workorderDTOS);
    }

    @PutMapping("/workorders/update")
    public ResponseEntity<Object> updateWorkOrder(@RequestBody WorkorderDTO workorderDTO) {

        try {
            return ResponseEntity.ok(workOrderService.updateWorkOrder(workorderDTO));

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

}
