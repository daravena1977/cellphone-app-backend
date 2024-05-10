package com.diegoaravena.cellphoneserviceapp.controllers;

import com.diegoaravena.cellphoneserviceapp.dtos.RepairDTO;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Repair;
import com.diegoaravena.cellphoneserviceapp.repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RepairController {

    @Autowired
    private RepairRepository repairRepository;

    @GetMapping("/repairs")
    public List<RepairDTO> getRepairsDTO(){
        return repairRepository
                .findAll()
                .stream()
                .map(RepairDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/repairs")
    public ResponseEntity<Object> createRepair(@RequestParam String typeRepair){
        if (typeRepair.isBlank()){
            return new ResponseEntity<>("The type repair data is missing", HttpStatus.FORBIDDEN);
        }

        if (repairRepository.existsByRepairType(typeRepair)){
            return new ResponseEntity<>("The type repair already exists", HttpStatus.FORBIDDEN);
        }

        Repair repair = new Repair(typeRepair.toUpperCase());

        repairRepository.save(repair);

        return new ResponseEntity<>("Repair type created successfully", HttpStatus.CREATED);
    }

}
