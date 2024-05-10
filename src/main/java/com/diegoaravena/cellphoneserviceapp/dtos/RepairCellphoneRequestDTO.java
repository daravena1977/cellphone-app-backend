package com.diegoaravena.cellphoneserviceapp.dtos;

public class RepairCellphoneRequestDTO {

    private Long idBrand;
    private Long idModel;
    private Long idTypeRepair;

    public Long getIdBrand() {
        return idBrand;
    }

    public Long getIdModel() {
        return idModel;
    }

    public Long getIdTypeRepair() {
        return idTypeRepair;
    }
}
