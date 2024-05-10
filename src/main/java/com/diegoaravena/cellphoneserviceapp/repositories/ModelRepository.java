package com.diegoaravena.cellphoneserviceapp.repositories;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ModelRepository extends JpaRepository<Model, Long> {
    boolean existsByName(String name);

}
