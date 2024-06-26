package com.diegoaravena.cellphoneserviceapp.services;


import com.diegoaravena.cellphoneserviceapp.models.otherclass.RepairCellphone;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Workorder;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.WorkorderRepairCellphone;

import java.util.Set;

public interface WorkorderRepairCellphoneService {
    Set<WorkorderRepairCellphone> findAll();

    WorkorderRepairCellphone findById(Long id);

    WorkorderRepairCellphone save(WorkorderRepairCellphone workorderRepairCellphone);

    void deleteById(Long id);

    WorkorderRepairCellphone updateWorkorderRepairCellphone(WorkorderRepairCellphone workorderRepairCellphone);

    boolean existsByRepairCellphoneAndWorkOrder(RepairCellphone repairCellphone, Workorder workorder);
}
