package com.diegoaravena.cellphoneserviceapp.controllers;

import com.diegoaravena.cellphoneserviceapp.dtos.BrandDTO;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;
import com.diegoaravena.cellphoneserviceapp.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:8081/", maxAge = 3600, allowCredentials = "true")
@RequestMapping("/api")
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping("/brands")
    public List<BrandDTO> getBrandsDTO(){
        return brandRepository
                .findAll()
                .stream()
                .map(BrandDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/brands")
    public ResponseEntity<Object> createBrand(@RequestParam String name){
        if (name.isBlank()){
            return new ResponseEntity<>("The name data is missing", HttpStatus.FORBIDDEN);
        }

        if (brandRepository.existsByName(name.toUpperCase())){
            return new ResponseEntity<>("This name already exists", HttpStatus.FORBIDDEN);
        }

        Brand brand = new Brand(name.toUpperCase());

        brandRepository.save(brand);

        return new ResponseEntity<>("The name data created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/brands/{id}")
    public ResponseEntity<Object> deleteBrand(@PathVariable Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow(null);

        if (brand == null){
            return new ResponseEntity<>("This brand don't exists", HttpStatus.FORBIDDEN);
        }

        brandRepository.deleteById(id);

        return  new ResponseEntity<>("This brand was deleting successfully!", HttpStatus.OK);
    }

}
