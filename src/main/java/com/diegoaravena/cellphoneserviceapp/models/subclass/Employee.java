package com.diegoaravena.cellphoneserviceapp.models.subclass;

import com.diegoaravena.cellphoneserviceapp.models.superclass.Person;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Employee extends Person {

    private LocalDate dateOfEmployment;

    public Employee() {
    }

    public Employee(String dni, String firstName, String lastName, String email, String password, LocalDate dateOfEmployment) {
        super(dni, firstName, lastName, email, password);
        this.dateOfEmployment = dateOfEmployment;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
}
