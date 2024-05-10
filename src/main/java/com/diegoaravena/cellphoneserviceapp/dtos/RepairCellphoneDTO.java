package com.diegoaravena.cellphoneserviceapp.dtos;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Cellphone;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Repair;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.RepairCellphone;

public class RepairCellphoneDTO {
    private Long id;
    private Double price;
    private RepairDTO repair;
    private CellphoneDTO cellphone;

    public RepairCellphoneDTO() {
    }

    public RepairCellphoneDTO(RepairCellphone repairCellphone) {
        id = repairCellphone.getId();
        price = repairCellphone.getPrice();
        repair = new RepairDTO(repairCellphone.getRepair());
        cellphone = new CellphoneDTO(repairCellphone.getCellPhone());

    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public RepairDTO getRepair() {
        return repair;
    }

    public CellphoneDTO getCellphone() {
        return cellphone;
    }
}
