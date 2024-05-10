package com.diegoaravena.cellphoneserviceapp.dtos;

import com.diegoaravena.cellphoneserviceapp.models.enums.StateOrder;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Workorder;
import com.diegoaravena.cellphoneserviceapp.models.subclass.Client;

import java.net.http.WebSocket;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WorkorderDTO {
    private Long id;
    private Integer number;
    private LocalDate creationDate;
    private LocalDate deliverDate;
    private String description;
    private StateOrder stateOrder;

    private Set<WorkorderRepairCellphoneDTO> workorderRepairCellphones;

    private Long idClient;

    public WorkorderDTO(Workorder workorder) {
        id = workorder.getId();
        number = workorder.getNumber();
        creationDate = workorder.getCreationDate();
        deliverDate = workorder.getDeliverDate();
        description = workorder.getDescription();
        stateOrder = workorder.getStateOrder();
        workorderRepairCellphones = workorder.getWorkorderRepairCellphones()
                .stream()
                .map(WorkorderRepairCellphoneDTO::new).collect(Collectors.toSet());
        idClient = workorder.getClient().getId();

    }

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
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
    public Set<WorkorderRepairCellphoneDTO> getWorkorderRepairCellphones() {
        return workorderRepairCellphones;
    }

    public Long getIdClient() {
        return idClient;
    }
}
