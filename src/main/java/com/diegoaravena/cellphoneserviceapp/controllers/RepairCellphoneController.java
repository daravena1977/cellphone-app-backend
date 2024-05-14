package com.diegoaravena.cellphoneserviceapp.controllers;

import com.diegoaravena.cellphoneserviceapp.dtos.RepairCellphoneDTO;
import com.diegoaravena.cellphoneserviceapp.dtos.RepairCellphoneRequestDTO;
import com.diegoaravena.cellphoneserviceapp.dtos.newRepairCellphoneDTO;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.*;
import com.diegoaravena.cellphoneserviceapp.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RepairCellphoneController {

    @Autowired
    private RepairCellphoneRepository repairCellphoneRepository;

    @Autowired
    private CellphoneRepository cellphoneRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private RepairRepository repairRepository;

    @GetMapping("/repaircellphones")
    public List<RepairCellphoneDTO> getRepairCellphonesDTO(){
        return repairCellphoneRepository
                .findAll()
                .stream()
                .map(RepairCellphoneDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/repaircellphone")
    public ResponseEntity<Object> getRepairCellphoneDTO(@RequestBody RepairCellphoneRequestDTO repairCellphoneRequestDTO){
        Brand brand = brandRepository.findById(repairCellphoneRequestDTO.getIdBrand()).orElse(null);

        Model model = modelRepository.findById(repairCellphoneRequestDTO.getIdModel()).orElse(null);

        Cellphone cellphone = cellphoneRepository.findByBrandAndModel(brand, model);

        Repair repair = repairRepository.findById(repairCellphoneRequestDTO.getIdTypeRepair()).orElse(null);

        return ResponseEntity.ok(new RepairCellphoneDTO (repairCellphoneRepository
                .findByCellPhoneAndRepair(cellphone, repair)));
    }

    @PostMapping("/repaircellphones")
    public ResponseEntity<Object> createRepairCellphone(@RequestBody newRepairCellphoneDTO newRepairCellphoneDTO){
        Brand brand = brandRepository.findById(newRepairCellphoneDTO.getIdBrand()).orElse(null);

        Model model = modelRepository.findById(newRepairCellphoneDTO.getIdModel()).orElse(null);

        Cellphone cellphone = cellphoneRepository.findByBrandAndModel(brand,
                model);

        Repair repair = repairRepository.findById(newRepairCellphoneDTO.getIdTypeRepair()).orElse(null);

        if (newRepairCellphoneDTO.getIdBrand() == null){
            return new ResponseEntity<>("The id cellphone brand is missing", HttpStatus.FORBIDDEN);
        }

        if (newRepairCellphoneDTO.getIdModel() == null){
            return new ResponseEntity<>("The id cellphone model is missing", HttpStatus.FORBIDDEN);
        }

        if (newRepairCellphoneDTO.getIdTypeRepair() == null){
            return new ResponseEntity<>("The id cellphone type repair is missing", HttpStatus.FORBIDDEN);
        }

        if (cellphone == null){
            return new ResponseEntity<>("The cellphone don't exists", HttpStatus.FORBIDDEN);
        }

        if (repair == null){
            return new ResponseEntity<>("The repair data don't exists", HttpStatus.FORBIDDEN);
        }

        if (newRepairCellphoneDTO.getPrice() == null){
            return new ResponseEntity<>("The price data is missing", HttpStatus.FORBIDDEN);
        }

        if (newRepairCellphoneDTO.getPrice() <= 0){
            return new ResponseEntity<>("The price must be greater than 0", HttpStatus.FORBIDDEN);
        }

        if (repairCellphoneRepository.existsByCellPhoneAndRepair(cellphone, repair)){
            return new ResponseEntity<>("This cellphone repair type exists", HttpStatus.FORBIDDEN);
        }

        RepairCellphone repairCellphone = new RepairCellphone(newRepairCellphoneDTO.getPrice());

        repair.addRepairCellphone(repairCellphone);
        cellphone.addRepairCellphone(repairCellphone);

        repairCellphoneRepository.save(repairCellphone);

        return new ResponseEntity<>("This type repair was created successfully", HttpStatus.CREATED);

    }

}
