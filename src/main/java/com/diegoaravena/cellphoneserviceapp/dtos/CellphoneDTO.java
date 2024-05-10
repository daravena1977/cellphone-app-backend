package com.diegoaravena.cellphoneserviceapp.dtos;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Cellphone;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Model;

import java.util.List;
import java.util.stream.Collectors;

public class CellphoneDTO {
    private Long id;
    private String brand;
    private String model;



    public CellphoneDTO() {
    }

    public CellphoneDTO(Cellphone cellphone) {
        id = cellphone.getId();
        brand = cellphone.getBrand().getName();
        model = cellphone.getModel().getName();

    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
