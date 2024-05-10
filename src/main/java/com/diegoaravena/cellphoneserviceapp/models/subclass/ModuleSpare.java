package com.diegoaravena.cellphoneserviceapp.models.subclass;


import com.diegoaravena.cellphoneserviceapp.models.enums.EQuality;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Model;
import com.diegoaravena.cellphoneserviceapp.models.superclass.CellPhoneSpare;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class ModuleSpare extends CellPhoneSpare {

    @Enumerated(EnumType.STRING)
    private EQuality quality;

    private Boolean frame;

    public ModuleSpare() {
    }

    public ModuleSpare(Brand brand, Model model, Double price, Integer stock,
                       EQuality quality, Boolean frame) {
        super(brand, model, price, stock);
        this.quality = quality;
        this.frame = frame;
    }

    public EQuality getQuality() {
        return quality;
    }

    public void setQuality(EQuality quality) {
        this.quality = quality;
    }

    public Boolean getFrame() {
        return frame;
    }

    public void setFrame(Boolean frame) {
        this.frame = frame;
    }
}
