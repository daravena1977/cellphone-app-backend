package com.diegoaravena.cellphoneserviceapp.models.otherclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CorrelativeWorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int correlativeNumber;
    private int yearCorrelative;

    public CorrelativeWorkOrder() {
    }

    public CorrelativeWorkOrder(int correlativeNumber, int yearCorrelative) {
        this.correlativeNumber = correlativeNumber;
        this.yearCorrelative = yearCorrelative;
    }

    public Long getId() {
        return id;
    }

    public int getCorrelativeNumber() {
        return correlativeNumber;
    }

    public void setCorrelativeNumber(int correlativeNumber) {
        this.correlativeNumber = correlativeNumber;
    }

    public int getYearCorrelative() {
        return yearCorrelative;
    }

    public void setYearCorrelative(int year) {
        this.yearCorrelative = year;
    }
}
