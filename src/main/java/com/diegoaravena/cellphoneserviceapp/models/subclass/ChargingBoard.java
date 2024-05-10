package com.diegoaravena.cellphoneserviceapp.models.subclass;

import com.diegoaravena.cellphoneserviceapp.models.enums.ETypeChargingPin;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Model;
import com.diegoaravena.cellphoneserviceapp.models.superclass.CellPhoneSpare;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class ChargingBoard extends CellPhoneSpare {

    @Enumerated(EnumType.STRING)
    private ETypeChargingPin typeChargingPin;

    public ChargingBoard() {
    }

    public ChargingBoard(Brand brand, Model model, Double price, Integer stock,
                         ETypeChargingPin typeChargingPin) {
        super(brand, model, price, stock);
        this.typeChargingPin = typeChargingPin;
    }

    public ETypeChargingPin getTypeChargingPin() {
        return typeChargingPin;
    }

    public void setTypeChargingPin(ETypeChargingPin typeChargingPin) {
        this.typeChargingPin = typeChargingPin;
    }
}
