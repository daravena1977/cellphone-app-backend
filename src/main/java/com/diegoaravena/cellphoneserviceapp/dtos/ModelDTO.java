package com.diegoaravena.cellphoneserviceapp.dtos;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Model;

public class ModelDTO {
    private Long id;
    private String name;

    public ModelDTO() {
    }

    public ModelDTO(Model model) {
        id = model.getId();
        name = model.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
