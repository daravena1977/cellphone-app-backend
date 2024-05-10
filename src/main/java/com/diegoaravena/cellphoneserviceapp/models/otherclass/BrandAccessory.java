package com.diegoaravena.cellphoneserviceapp.models.otherclass;

import com.diegoaravena.cellphoneserviceapp.models.superclass.Accessory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BrandAccessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "brandAccessory",
            cascade = CascadeType.ALL)
    List<Accessory> accessories = new ArrayList<>();

    public BrandAccessory() {
    }

    public BrandAccessory(String name) {
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
}


