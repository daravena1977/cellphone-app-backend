package com.diegoaravena.cellphoneserviceapp.repositories;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Brand;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Cellphone;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CellphoneRepository extends JpaRepository<Cellphone, Long> {

    Cellphone findByBrandAndModel(Brand brand, Model model);

}
