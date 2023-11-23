package com.diegoaravena.cellphoneserviceapp.models.subclass;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Workorder;
import com.diegoaravena.cellphoneserviceapp.models.superclass.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;


@Entity
public class Client extends User {

    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private Set<Workorder> workOrders;

    public Client() {
    }

    public Client(String dni, String firstName, String lastName, String email, String password, String phoneNumber) {
        super(dni, firstName, lastName, email, password);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Workorder> getWorkOrders() {
        return workOrders;
    }

    public void setWorkOrders(Set<Workorder> workOrders) {
        this.workOrders = workOrders;
    }

}
