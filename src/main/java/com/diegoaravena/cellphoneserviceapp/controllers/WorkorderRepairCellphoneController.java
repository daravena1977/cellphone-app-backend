package com.diegoaravena.cellphoneserviceapp.controllers;

import com.diegoaravena.cellphoneserviceapp.dtos.NewWorkorderRepairCellphoneDTO;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.RepairCellphone;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Workorder;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.WorkorderRepairCellphone;
import com.diegoaravena.cellphoneserviceapp.repositories.WorkorderRepository;
import com.diegoaravena.cellphoneserviceapp.services.RepairCellphoneService;
import com.diegoaravena.cellphoneserviceapp.services.WorkOrderService;
import com.diegoaravena.cellphoneserviceapp.services.WorkorderRepairCellphoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api")
public class WorkorderRepairCellphoneController {

    private final WorkorderRepairCellphoneService workorderRepairCellphoneService;

    private final RepairCellphoneService repairCellphoneService;

    private final WorkorderRepository workorderRepository;



    public WorkorderRepairCellphoneController(WorkorderRepairCellphoneService workorderRepairCellphoneService,
                                              RepairCellphoneService repairCellphoneService, WorkorderRepository workorderRepository) {
        this.workorderRepairCellphoneService = workorderRepairCellphoneService;
        this.repairCellphoneService = repairCellphoneService;
        this.workorderRepository = workorderRepository;
    }

    @DeleteMapping("/workorderRepairCellphone/delete-by-id")
    public ResponseEntity<Void> deleteWorkorderRepairCellphoneById(@RequestParam Long id) {

        try {
            workorderRepairCellphoneService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/workordersRepairCellphone/new-repair")
    public ResponseEntity<WorkorderRepairCellphone> addWorkorderRepairCellphone(@RequestBody NewWorkorderRepairCellphoneDTO                                                                                                newWorkorderRepairCellphoneDTO) {

        WorkorderRepairCellphone workorderRepairCellphone =
                new WorkorderRepairCellphone(newWorkorderRepairCellphoneDTO.getPrice());

        RepairCellphone repairCellphone = repairCellphoneService
                .findById(newWorkorderRepairCellphoneDTO.getIdRepair());

        Workorder workorder = workorderRepository
                .findById(newWorkorderRepairCellphoneDTO.getIdWorkorder()).orElse(null);

        workorderRepairCellphone.setRepairCellphone(repairCellphone);
        workorderRepairCellphone.setWorkOrder(workorder);


        workorderRepairCellphoneService.save(workorderRepairCellphone);

        return ResponseEntity.ok(workorderRepairCellphone);
    }
}
