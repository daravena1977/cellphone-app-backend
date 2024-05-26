package com.diegoaravena.cellphoneserviceapp.dtos;

public class NewWorkorderRepairCellphoneDTO {
    private Long idRepair;
    private Double price;
    private Long idWorkorder;

    public NewWorkorderRepairCellphoneDTO() {
    }

    public Long getIdRepair() {
        return idRepair;
    }

    public Double getPrice() {
        return price;
    }

    public Long getIdWorkorder() {
        return idWorkorder;
    }
}
