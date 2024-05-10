package com.diegoaravena.cellphoneserviceapp.models.otherclass;

import javax.persistence.*;

@Entity
public class WorkorderRepairCellphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double payment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Workorder workOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    private RepairCellphone repairCellphone;

    public WorkorderRepairCellphone() {
    }

    public WorkorderRepairCellphone(Double payment) {
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Workorder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(Workorder workOrder) {
        this.workOrder = workOrder;
    }

    public RepairCellphone getRepairCellphone() {
        return repairCellphone;
    }

    public void setRepairCellphone(RepairCellphone repairCellphone) {
        this.repairCellphone = repairCellphone;
    }


}
