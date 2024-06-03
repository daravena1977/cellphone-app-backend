package com.diegoaravena.cellphoneserviceapp.services.implement;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.RepairCellphone;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Workorder;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.WorkorderRepairCellphone;
import com.diegoaravena.cellphoneserviceapp.repositories.WorkorderRepairCellphoneRepository;
import com.diegoaravena.cellphoneserviceapp.services.WorkorderRepairCellphoneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Set;

@Service
public class WorkorderRepairCellphoneServiceImp implements WorkorderRepairCellphoneService {

    private final WorkorderRepairCellphoneRepository workorderRepairCellphoneRepository;

    public WorkorderRepairCellphoneServiceImp(WorkorderRepairCellphoneRepository
                                                      workorderRepairCellphoneRepository) {
        this.workorderRepairCellphoneRepository = workorderRepairCellphoneRepository;
    }

    @Override
    public Set<WorkorderRepairCellphone> findAll() {
        return Set.of();
    }

    @Override
    public WorkorderRepairCellphone findById(Long id) {
        return null;
    }

    @Override
    public WorkorderRepairCellphone save(WorkorderRepairCellphone workorderRepairCellphone) {
        return workorderRepairCellphoneRepository.save(workorderRepairCellphone);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (workorderRepairCellphoneRepository.existsById(id)) {
            workorderRepairCellphoneRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Esta reparación no se ha encontrado");
        }
    }

    @Override
    public WorkorderRepairCellphone updateWorkorderRepairCellphone(WorkorderRepairCellphone workorderRepairCellphone) {
        return null;
    }

    @Override
    public boolean existsByRepairCellphoneAndWorkOrder(RepairCellphone repairCellphone, Workorder workorder) {
        return this.workorderRepairCellphoneRepository
                .existsByRepairCellphoneAndWorkOrder(repairCellphone, workorder);
    }


}
