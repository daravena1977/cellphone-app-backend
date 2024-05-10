package com.diegoaravena.cellphoneserviceapp.models.subclass;

import com.diegoaravena.cellphoneserviceapp.models.superclass.User;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

    public Admin() {
    }

    public Admin(String dni, String firstName, String lastName, String email, String password) {
        super(dni, firstName, lastName, email, password);
    }
}
