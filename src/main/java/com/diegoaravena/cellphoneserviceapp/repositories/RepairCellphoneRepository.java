package com.diegoaravena.cellphoneserviceapp.repositories;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Cellphone;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Repair;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.RepairCellphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RepairCellphoneRepository extends JpaRepository<RepairCellphone, Long> {

    boolean existsByCellPhoneAndRepair(Cellphone cellphone, Repair repair);

    RepairCellphone findByCellPhoneAndRepair(Cellphone cellphone, Repair repair);

}
