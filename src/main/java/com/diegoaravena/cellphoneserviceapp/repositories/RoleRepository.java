package com.diegoaravena.cellphoneserviceapp.repositories;

import com.diegoaravena.cellphoneserviceapp.models.enums.ERole;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

}
