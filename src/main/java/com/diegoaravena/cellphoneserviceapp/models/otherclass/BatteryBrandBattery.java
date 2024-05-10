package com.diegoaravena.cellphoneserviceapp.models.otherclass;

import com.diegoaravena.cellphoneserviceapp.models.subclass.Battery;

import javax.persistence.*;

@Entity
public class BatteryBrandBattery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Battery battery;

    @ManyToOne(fetch = FetchType.LAZY)
    private BrandBattery brandBattery;

    public BatteryBrandBattery() {
    }

    public Long getId() {
        return id;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public BrandBattery getBrandBattery() {
        return brandBattery;
    }

    public void setBrandBattery(BrandBattery brandBattery) {
        this.brandBattery = brandBattery;
    }
}
