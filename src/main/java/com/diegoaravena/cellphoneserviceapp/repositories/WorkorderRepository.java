package com.diegoaravena.cellphoneserviceapp.repositories;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.Workorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource
public interface WorkorderRepository extends JpaRepository<Workorder, Long> {

    boolean existsByNumberAndCreationDate(Integer number, LocalDate creationDate);

    List<Workorder> findByIsEnding(boolean state);

    Workorder findByNumber(Integer number);
}
