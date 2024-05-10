package com.diegoaravena.cellphoneserviceapp.models.subclass;

import com.diegoaravena.cellphoneserviceapp.models.enums.EQualityBattery;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.BatteryBrandBattery;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Model;
import com.diegoaravena.cellphoneserviceapp.models.superclass.CellPhoneSpare;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Battery extends CellPhoneSpare {

    @Enumerated(EnumType.STRING)
    private EQualityBattery eQualityBattery;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "battery")
    private Set<BatteryBrandBattery> batteryBrandBatteries = new HashSet<>();

    public Battery() {
    }

    public Battery(Brand brand, Model model, Double price, Integer stock,
                   EQualityBattery eQualityBattery) {
        super(brand, model, price, stock);
        this.eQualityBattery = eQualityBattery;
    }

    public EQualityBattery geteQualityBattery() {
        return eQualityBattery;
    }

    public void seteQualityBattery(EQualityBattery eQualityBattery) {
        this.eQualityBattery = eQualityBattery;
    }

    public Set<BatteryBrandBattery> getBatteryBrandBatteries() {
        return batteryBrandBatteries;
    }

    public void addBatteryBrandBattery(BatteryBrandBattery batteryBrandBattery) {
        batteryBrandBattery.setBattery(this);
        batteryBrandBatteries.add(batteryBrandBattery);
    }
}
