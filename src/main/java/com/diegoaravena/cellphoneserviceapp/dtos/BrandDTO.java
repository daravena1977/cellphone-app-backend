package com.diegoaravena.cellphoneserviceapp.dtos;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BrandDTO {

    private Long id;
    private String name;

    List<ModelDTO> models;

    public BrandDTO() {
    }

    public BrandDTO(Brand brand) {
        id = brand.getId();
        name = brand.getName();
        models = brand.getModels()
                .stream()
                .map(ModelDTO::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ModelDTO> getModels() {
        return models;
    }
}
