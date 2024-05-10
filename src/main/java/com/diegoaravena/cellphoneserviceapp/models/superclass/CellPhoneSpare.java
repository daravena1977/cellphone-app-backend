package com.diegoaravena.cellphoneserviceapp.models.superclass;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class CellPhoneSpare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    private Model model;

    private Double price;

    private Integer stock;

    public CellPhoneSpare() {
    }

    public CellPhoneSpare(Brand brand, Model model, Double price, Integer stock) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
