package com.diegoaravena.cellphoneserviceapp.models.subclass;

import com.diegoaravena.cellphoneserviceapp.models.enums.ETypeChargingPin;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.BrandAccessory;
import com.diegoaravena.cellphoneserviceapp.models.superclass.Accessory;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class CellPhoneCharger extends Accessory {

    @Enumerated(EnumType.STRING)
    private ETypeChargingPin typeChargingPin;

    public CellPhoneCharger() {
    }

    public CellPhoneCharger(Brand brand, BrandAccessory brandAccessory, Double price, Integer stock,
                            ETypeChargingPin typeChargingPin) {
        super(brand, brandAccessory, price, stock);
        this.typeChargingPin = typeChargingPin;
    }

    public ETypeChargingPin getTypeChargingPin() {
        return typeChargingPin;
    }

    public void setTypeChargingPin(ETypeChargingPin typeChargingPin) {
        this.typeChargingPin = typeChargingPin;
    }
}
