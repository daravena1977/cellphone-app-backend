package com.diegoaravena.cellphoneserviceapp.repositories;

import com.diegoaravena.cellphoneserviceapp.models.subclass.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
