package com.diegoaravena.cellphoneserviceapp.dtos;

public class newRepairCellphoneDTO {

    private Long idBrand;
    private Long idModel;
    private Long idTypeRepair;
    private Double price;

    public Long getIdBrand() {
        return idBrand;
    }

    public Long getIdModel() {
        return idModel;
    }

    public Long getIdTypeRepair() {
        return idTypeRepair;
    }

    public Double getPrice() {
        return price;
    }
}
