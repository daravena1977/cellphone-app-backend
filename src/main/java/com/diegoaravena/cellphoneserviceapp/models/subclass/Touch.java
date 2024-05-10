package com.diegoaravena.cellphoneserviceapp.models.subclass;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Model;
import com.diegoaravena.cellphoneserviceapp.models.superclass.CellPhoneSpare;

import javax.persistence.Entity;

@Entity
public class Touch extends CellPhoneSpare {

    private Boolean withLogo;

    public Touch() {
    }

    public Touch(Brand brand, Model model, Double price, Integer stock, Boolean withLogo) {
        super(brand, model, price, stock);
        this.withLogo = withLogo;
    }

    public Boolean getWithLogo() {
        return withLogo;
    }

    public void setWithLogo(Boolean withLogo) {
        this.withLogo = withLogo;
    }
}
