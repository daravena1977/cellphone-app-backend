package com.diegoaravena.cellphoneserviceapp.models.otherclass;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class BrandBattery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "brandBattery")
    private Set<BatteryBrandBattery> batteryBrandBatteries = new HashSet<>();

    public BrandBattery() {
    }

    public BrandBattery(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BatteryBrandBattery> getBatteryBrandBatteries() {
        return batteryBrandBatteries;
    }

    public void addBatteryBrandBattery(BatteryBrandBattery batteryBrandBattery) {
        batteryBrandBattery.setBrandBattery(this);
        batteryBrandBatteries.add(batteryBrandBattery);
    }
}
