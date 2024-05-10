package com.diegoaravena.cellphoneserviceapp.dtos;

import java.util.Set;

public class RepairCellphoneDTOS {

    private Set<RepairCellphoneDTO> repairCellphoneDTOS;

    public RepairCellphoneDTOS() {
    }

    public RepairCellphoneDTOS(Set<RepairCellphoneDTO> repairCellphoneDTOS) {
        this.repairCellphoneDTOS = repairCellphoneDTOS;
    }

    public Set<RepairCellphoneDTO> getRepairCellphoneDTOS() {
        return repairCellphoneDTOS;
    }

    public void setRepairCellphoneDTOS(Set<RepairCellphoneDTO> repairCellphoneDTOS) {
        this.repairCellphoneDTOS = repairCellphoneDTOS;
    }

}
