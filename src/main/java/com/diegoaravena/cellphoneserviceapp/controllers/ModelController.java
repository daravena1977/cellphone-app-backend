package com.diegoaravena.cellphoneserviceapp.controllers;

import com.diegoaravena.cellphoneserviceapp.dtos.ModelDTO;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Model;
import com.diegoaravena.cellphoneserviceapp.repositories.BrandRepository;
import com.diegoaravena.cellphoneserviceapp.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ModelController {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private BrandRepository brandRepository;

    @PostMapping("/models")
    public ResponseEntity<Object> createModel(@RequestParam String nameModel, @RequestParam Long id){
        Brand brand = brandRepository.findById(id).orElseThrow(null);

        if (brand == null){
            return new ResponseEntity<>("The brand don't exists in database", HttpStatus.FORBIDDEN);
        }

        if (nameModel.isBlank()){
            return new ResponseEntity<>("The name model data is missing", HttpStatus.FORBIDDEN);
        }

        if (modelRepository.existsByName(nameModel.toUpperCase())){
            return new ResponseEntity<>("This name model exists in database", HttpStatus.FORBIDDEN);
        }

        Model model = new Model(nameModel.toUpperCase());

        model.setBrand(brand);

        modelRepository.save(model);

        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @GetMapping("/models")
    public List<ModelDTO> getModelsDTO(){
        return modelRepository
                .findAll()
                .stream()
                .map(ModelDTO::new).collect(Collectors.toList());
    }
}
