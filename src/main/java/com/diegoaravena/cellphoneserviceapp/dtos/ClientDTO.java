package com.diegoaravena.cellphoneserviceapp.dtos;

import com.diegoaravena.cellphoneserviceapp.models.subclass.Client;

import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {

    private Long id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;

    private Set<WorkorderDTO> workorders;

    public ClientDTO(Client client) {
        id = client.getId();
        dni = client.getDni();
        firstName = client.getFirstName();
        lastName = client.getLastName();
        email = client.getEmail();
        phoneNumber = client.getPhoneNumber();
        address = client.getAddress();
        workorders = client.getWorkOrders()
                .stream()
                .map(WorkorderDTO::new)
                .collect(Collectors.toSet());

    }

    public Long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Set<WorkorderDTO> getWorkorders() {
        return workorders;
    }
}
