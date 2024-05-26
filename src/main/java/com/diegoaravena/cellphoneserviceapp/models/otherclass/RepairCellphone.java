package com.diegoaravena.cellphoneserviceapp.models.otherclass;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RepairCellphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Repair repair;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cellphone cellPhone;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairCellphone")
    private Set<WorkorderRepairCellphone> workorderRepairCellphones;

    public RepairCellphone() {
    }

    public RepairCellphone(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public Cellphone getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Cellphone cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Set<WorkorderRepairCellphone> getWorkorderRepairCellphones() {
        return workorderRepairCellphones;
    }

    public void addRepair(WorkorderRepairCellphone workorderRepairCellphone) {
        workorderRepairCellphone.setRepairCellphone(this);
        workorderRepairCellphones.add(workorderRepairCellphone);
    }
}
