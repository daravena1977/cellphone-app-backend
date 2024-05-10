package com.diegoaravena.cellphoneserviceapp.models.otherclass;

import com.diegoaravena.cellphoneserviceapp.models.superclass.CellPhoneSpare;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Brand brand;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model")
    List<Cellphone> cellphones = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model")
    List<CellPhoneSpare> cellPhoneSpares = new ArrayList<>();

    public Model() {
    }

    public Model(String name) {
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

    public Brand getBrand() {
        return brand;
    }

    @JsonIgnore
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @JsonIgnore
    public List<Cellphone> getCellphones() {
        return cellphones;
    }

    public void addCellphone(Cellphone cellphone) {
        cellphone.setModel(this);
        cellphones.add(cellphone);
    }

    public List<CellPhoneSpare> getCellPhoneSpares() {
        return cellPhoneSpares;
    }

    public void addCellphoneSpare(CellPhoneSpare cellPhoneSpare) {
        cellPhoneSpare.setModel(this);
        cellPhoneSpares.add(cellPhoneSpare);
    }
}
