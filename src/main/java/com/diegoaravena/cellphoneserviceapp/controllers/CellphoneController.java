package com.diegoaravena.cellphoneserviceapp.controllers;

import com.diegoaravena.cellphoneserviceapp.dtos.CellphoneDTO;
import com.diegoaravena.cellphoneserviceapp.dtos.newCellphoneDTO;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Cellphone;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Model;
import com.diegoaravena.cellphoneserviceapp.repositories.BrandRepository;
import com.diegoaravena.cellphoneserviceapp.repositories.CellphoneRepository;
import com.diegoaravena.cellphoneserviceapp.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CellphoneController {

    @Autowired
    private CellphoneRepository cellphoneRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;

    @GetMapping("/cellphones")
    public List<CellphoneDTO> getCellphonesDTO() {
        return cellphoneRepository
                .findAll()
                .stream()
                .map(CellphoneDTO::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/cellphones")
    public ResponseEntity<Object> createCellphone(@RequestBody newCellphoneDTO newCellphoneDTO){
        if (newCellphoneDTO.getIdBrand() == null) {
            return new ResponseEntity<>("cellphone brand data is missing", HttpStatus.FORBIDDEN);
        }

        if (newCellphoneDTO.getIdModel() == null) {
            return new ResponseEntity<>("cellphone model data is missing", HttpStatus.FORBIDDEN);
        }

        Brand brand = brandRepository.findById(newCellphoneDTO.getIdBrand()).orElse(null);

        Model model = modelRepository.findById(newCellphoneDTO.getIdModel()).orElse(null);

        Cellphone cellphone = new Cellphone(brand, model);

        cellphoneRepository.save(cellphone);

        return new ResponseEntity<>("Cellphone entity has been created successfully", HttpStatus.CREATED);
    }

}
