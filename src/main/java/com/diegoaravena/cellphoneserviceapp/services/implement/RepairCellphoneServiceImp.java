package com.diegoaravena.cellphoneserviceapp.services.implement;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.RepairCellphone;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.WorkorderRepairCellphone;
import com.diegoaravena.cellphoneserviceapp.repositories.RepairCellphoneRepository;
import com.diegoaravena.cellphoneserviceapp.services.RepairCellphoneService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RepairCellphoneServiceImp implements RepairCellphoneService {
    private final RepairCellphoneRepository repairCellphoneRepository;

    public RepairCellphoneServiceImp(RepairCellphoneRepository repairCellphoneRepository) {
        this.repairCellphoneRepository = repairCellphoneRepository;
    }


    @Override
    public Set<RepairCellphone> findAll() {
        return Set.of();
    }

    @Override
    public RepairCellphone findById(Long id) {
        return repairCellphoneRepository.findById(id).orElse(null);
    }

    @Override
    public RepairCellphone save(RepairCellphone repairCellphone) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
