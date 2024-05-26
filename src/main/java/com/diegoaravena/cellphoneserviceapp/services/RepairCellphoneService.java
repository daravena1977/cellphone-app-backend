package com.diegoaravena.cellphoneserviceapp.services;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.RepairCellphone;

import java.util.Set;

public interface RepairCellphoneService {

    Set<RepairCellphone> findAll();

    RepairCellphone findById(Long id);

    RepairCellphone save(RepairCellphone repairCellphone);

    void deleteById(Long id);


}
