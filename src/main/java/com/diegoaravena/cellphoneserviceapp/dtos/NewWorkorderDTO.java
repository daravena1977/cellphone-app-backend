package com.diegoaravena.cellphoneserviceapp.dtos;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Workorder;

import java.time.LocalDate;

public class NewWorkorderDTO {
    private Integer number;
    private LocalDate creationDate;
    private LocalDate deliverDate;
    private String description;
    private Boolean isEnding;

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

    public Boolean getEnding() {
        return isEnding;
    }
}
