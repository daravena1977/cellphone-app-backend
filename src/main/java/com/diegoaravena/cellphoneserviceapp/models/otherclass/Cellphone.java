package com.diegoaravena.cellphoneserviceapp.models.otherclass;


import com.diegoaravena.cellphoneserviceapp.models.enums.CellphoneColor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cellphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cellPhone")
    Set<RepairCellphone> repairCellphones = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    private Model model;

    public Cellphone() {
    }

    public Cellphone(Brand brand, Model model) {
        this.brand = brand;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @JsonIgnore
    public Set<RepairCellphone> getRepairCellphones() {
        return repairCellphones;
    }

    public void addRepairCellphone(RepairCellphone repairCellphone) {
        repairCellphone.setCellPhone(this);
        repairCellphones.add(repairCellphone);
    }
}
