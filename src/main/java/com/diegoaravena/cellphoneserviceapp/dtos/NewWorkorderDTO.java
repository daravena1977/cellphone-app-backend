package com.diegoaravena.cellphoneserviceapp.dtos;

import com.diegoaravena.cellphoneserviceapp.models.enums.StateOrder;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.RepairCellphone;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Workorder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewWorkorderDTO {
    private Integer number;
    private String dni;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
    private LocalDate creationDate;
    private LocalDate deliverDate;
    private String description;
    private StateOrder stateOrder;

    private Set<RepairCellphone> repairCellphones;

    public Integer getNumber() {
        return number;
    }

    public String getDni() {
        return dni;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getDeliverDate() {
        return deliverDate;
    }

    public String getDescription() {
        return description;
    }

    public StateOrder getStateOrder() {
        return stateOrder;
    }

    public Set<RepairCellphone> getRepairCellphones() {
        return repairCellphones;
    }
}
