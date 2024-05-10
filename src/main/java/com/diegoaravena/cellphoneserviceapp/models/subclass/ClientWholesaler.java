package com.diegoaravena.cellphoneserviceapp.models.subclass;

import com.diegoaravena.cellphoneserviceapp.models.superclass.Person;

import javax.persistence.Entity;

@Entity
public class ClientWholesaler extends Person {

    public ClientWholesaler() {
    }

    public ClientWholesaler(String dni, String firstName, String lastName, String email, String password) {
        super(dni, firstName, lastName, email, password);
    }
}
