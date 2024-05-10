package com.diegoaravena.cellphoneserviceapp.models.otherclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String repairType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repair")
    private Set<RepairCellphone> repairCellPhones = new HashSet<>();

    public Repair() {
    }

    public Repair(String repairType) {
        this.repairType = repairType;
    }

    public Long getId() {
        return id;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    @JsonIgnore
    public Set<RepairCellphone> getRepairCellPhones() {
        return repairCellPhones;
    }

    public void addRepairCellphone(RepairCellphone repairCellPhone) {
        repairCellPhone.setRepair(this);
        repairCellPhones.add(repairCellPhone);
    }
}
