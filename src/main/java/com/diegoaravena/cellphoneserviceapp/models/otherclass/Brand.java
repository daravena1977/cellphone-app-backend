package com.diegoaravena.cellphoneserviceapp.models.otherclass;

import com.diegoaravena.cellphoneserviceapp.models.superclass.Accessory;
import com.diegoaravena.cellphoneserviceapp.models.superclass.CellPhoneSpare;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "brand",
            cascade = CascadeType.ALL)
    List<Model> models = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "brand",
            cascade = CascadeType.ALL)
   List<Cellphone> cellphones = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "brand",
            cascade = CascadeType.ALL)
    List<CellPhoneSpare> cellPhoneSpares = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "brand",
            cascade = CascadeType.ALL)
    List<Accessory> accessories = new ArrayList<>();

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Model> getModels() {
        return models;
    }

    public void addModel(Model model) {
        model.setBrand(this);
        models.add(model);
    }

    public List<Cellphone> getCellphones() {
        return cellphones;
    }

    public void addCellPhone(Cellphone cellphone) {
        cellphone.setBrand(this);
        cellphones.add(cellphone);
    }

    public List<CellPhoneSpare> getCellPhoneSpares() {
        return cellPhoneSpares;
    }

    public void addCellphoneSpare(CellPhoneSpare cellPhoneSpare) {
        cellPhoneSpare.setBrand(this);
        cellPhoneSpares.add(cellPhoneSpare);
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void addAccessories(Accessory accessory) {
        accessory.setBrand(this);
        accessories.add(accessory);
    }
}
