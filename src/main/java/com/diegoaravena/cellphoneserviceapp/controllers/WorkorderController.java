package com.diegoaravena.cellphoneserviceapp.controllers;

import com.diegoaravena.cellphoneserviceapp.dtos.NewWorkorderDTO;
import com.diegoaravena.cellphoneserviceapp.dtos.WorkorderDTO;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Workorder;
import com.diegoaravena.cellphoneserviceapp.repositories.WorkorderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class WorkorderController {

    @Autowired
    private WorkorderRepository workorderRepository;

    @GetMapping("/workorders/{number}")
    public ResponseEntity<Object> getWorkorderByNumber(@PathVariable Integer number){
        if (workorderRepository.findByNumber(number) == null){
            return new ResponseEntity<>("This order don't exists in database", HttpStatus.FORBIDDEN);
        }

        WorkorderDTO workorderDTO = new WorkorderDTO(workorderRepository.findByNumber(number));
        return new ResponseEntity<>(workorderDTO, HttpStatus.OK);
    }

    @GetMapping("/workorders")
    public List<WorkorderDTO> getWorkordersDTO(){
        return workorderRepository
                .findAll()
                .stream()
                .map(WorkorderDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/workorders/status")
    public List<WorkorderDTO> getWorkordersPending(@RequestParam boolean isEnding){
        return workorderRepository
                .findByIsEnding(isEnding)
                .stream()
                .map(WorkorderDTO::new)
                .collect(Collectors.toList());
    }


    @PostMapping("/workorders")
    public ResponseEntity<Object> createWorkOrder(@RequestBody NewWorkorderDTO newWorkorderDTO){

        if (newWorkorderDTO.getNumber().toString().isBlank()){
            return new ResponseEntity<>("The number data is missing", HttpStatus.FORBIDDEN);
        }

        if (newWorkorderDTO.getCreationDate().isBefore(LocalDate.now())){
            return new ResponseEntity<>("This date is not the actual date", HttpStatus.FORBIDDEN);
        }

        if (newWorkorderDTO.getDescription().isBlank()){
            return new ResponseEntity<>("The description data is missing", HttpStatus.FORBIDDEN);
        }

        if (workorderRepository.existsByNumberAndCreationDate(newWorkorderDTO.getNumber(),
                newWorkorderDTO.getCreationDate())){
            return new ResponseEntity<>("This work order already exists", HttpStatus.FORBIDDEN);
        }

        Workorder workorder = new Workorder(newWorkorderDTO.getNumber(), newWorkorderDTO.getCreationDate(),
                newWorkorderDTO.getDeliverDate(), "the clients bring us two cellphones", false);


        workorderRepository.save(workorder);

        return new ResponseEntity<>("Work order was created successfully", HttpStatus.CREATED);

    }

}
