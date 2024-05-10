package com.diegoaravena.cellphoneserviceapp.dtos;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Repair;

public class RepairDTO {
    private Long id;
    private String repairType;

    public RepairDTO(Repair repair) {
        id = repair.getId();
        repairType = repair.getRepairType();

    }

    public Long getId() {
        return id;
    }

    public String getRepairType() {
        return repairType;
    }
}
