package com.diegoaravena.cellphoneserviceapp.dtos;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.CorrelativeWorkOrder;

public class CorrelativeWorkOrderDTO {

    private Long id;
    private int correlativeNumber;
    private int yearCorrelative;

    public CorrelativeWorkOrderDTO() {
    }

    public CorrelativeWorkOrderDTO(CorrelativeWorkOrder correlativeWorkOrder) {
        id = correlativeWorkOrder.getId();
        correlativeNumber = correlativeWorkOrder.getCorrelativeNumber();
        yearCorrelative = correlativeWorkOrder.getYearCorrelative();

    }

    public Long getId() {
        return id;
    }

    public int getCorrelativeNumber() {
        return correlativeNumber;
    }

    public int getYearCorrelative() {
        return yearCorrelative;
    }
}
