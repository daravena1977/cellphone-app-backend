package com.diegoaravena.cellphoneserviceapp.controllers;

import com.diegoaravena.cellphoneserviceapp.services.WorkorderRepairCellphoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api")
public class WorkorderRepairCellphoneController {

    private final WorkorderRepairCellphoneService workorderRepairCellphoneService;

    public WorkorderRepairCellphoneController(WorkorderRepairCellphoneService workorderRepairCellphoneService) {
        this.workorderRepairCellphoneService = workorderRepairCellphoneService;
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
}
