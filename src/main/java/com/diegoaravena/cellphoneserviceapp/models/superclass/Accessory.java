package com.diegoaravena.cellphoneserviceapp.models.superclass;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.BrandAccessory;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    private BrandAccessory brandAccessory;

    private Double price;

    private Integer stock;

    public Accessory() {
    }

    public Accessory(Brand brand, BrandAccessory brandAccessory, Double price, Integer stock) {
        this.brand = brand;
        this.brandAccessory = brandAccessory;
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

    public BrandAccessory getBrandAccessory() {
        return brandAccessory;
    }

    public void setBrandAccessory(BrandAccessory brandAccessory) {
        this.brandAccessory = brandAccessory;
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
