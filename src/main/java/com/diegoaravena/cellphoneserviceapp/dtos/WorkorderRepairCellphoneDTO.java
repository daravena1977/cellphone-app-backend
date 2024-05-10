package com.diegoaravena.cellphoneserviceapp.dtos;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.RepairCellphone;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Workorder;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.WorkorderRepairCellphone;

public class WorkorderRepairCellphoneDTO {

    private Long id;
    private Double payment;
    private Long  idWorkorder;
    private Long  idRepairCellphone;
    private String brand;
    private String model;
    private String typeRepair;


    public WorkorderRepairCellphoneDTO(WorkorderRepairCellphone workorderRepairCellphone) {
        id = workorderRepairCellphone.getId();
        payment = workorderRepairCellphone.getPayment();
        idWorkorder = workorderRepairCellphone.getWorkOrder().getId() ;
        idRepairCellphone = workorderRepairCellphone.getRepairCellphone().getId() ;
        brand = workorderRepairCellphone.getRepairCellphone().getCellPhone().getBrand().getName();
        model = workorderRepairCellphone.getRepairCellphone().getCellPhone().getModel().getName();
        typeRepair = workorderRepairCellphone.getRepairCellphone().getRepair().getRepairType();
    }

    public Long getId() {
        return id;
    }

    public Double getPayment() {
        return payment;
    }

    public Long getIdWorkorder() {
        return idWorkorder;
    }

    public Long getIdRepairCellphone() {
        return idRepairCellphone;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getTypeRepair() {
        return typeRepair;
    }
}
