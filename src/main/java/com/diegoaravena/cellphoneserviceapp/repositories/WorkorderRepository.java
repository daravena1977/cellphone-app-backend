package com.diegoaravena.cellphoneserviceapp.repositories;

import com.diegoaravena.cellphoneserviceapp.models.enums.StateOrder;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Workorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RepositoryRestResource
public interface WorkorderRepository extends JpaRepository<Workorder, Long> {

    boolean existsByNumberAndCreationDate(Integer number, LocalDate creationDate);

    boolean existsByNumber(Integer number);

    List<Workorder> findByStateOrder(StateOrder stateOrder);

    boolean existsByCreationDate(int year);

    Set<Workorder> findByNumber(Integer number);

    @Query("select w from Workorder w where w.creationDate between :startDate and :endDate")
    Set<Workorder> searchByDate(LocalDate startDate, LocalDate endDate);

    @Query("select w from Workorder w where w.stateOrder = :stateOrder")
    Set<Workorder> searchByState(StateOrder stateOrder);


}
