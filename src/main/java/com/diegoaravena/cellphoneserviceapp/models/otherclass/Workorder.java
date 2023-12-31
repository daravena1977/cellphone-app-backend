package com.diegoaravena.cellphoneserviceapp.models.otherclass;

import com.diegoaravena.cellphoneserviceapp.models.subclass.Client;
import net.bytebuddy.build.ToStringPlugin;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Workorder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private LocalDate creationDate;
    private LocalDate deliverDate;
    private String description;
    private Boolean isEnding;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workOrder")
    private Set<WorkorderRepairCellphone> workorderRepairCellphones = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    public Workorder() {
    }

    public Workorder(Integer number, LocalDate creationDate, LocalDate deliverDate, String description, Boolean isEnding) {
        this.number = number;
        this.creationDate = creationDate;
        this.deliverDate = deliverDate;
        this.description = description;
        this.isEnding = isEnding;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(LocalDate deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnding() {
        return isEnding;
    }

    public void setEnding(Boolean ending) {
        isEnding = ending;
    }

    public Set<WorkorderRepairCellphone> getWorkorderRepairCellphones() {
        return workorderRepairCellphones;
    }

    public void addRepair(WorkorderRepairCellphone workorderRepairCellphone) {
        workorderRepairCellphone.setWorkOrder(this);
        workorderRepairCellphones.add(workorderRepairCellphone);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
