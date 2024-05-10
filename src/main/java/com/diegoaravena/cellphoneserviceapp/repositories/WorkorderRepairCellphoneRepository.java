package com.diegoaravena.cellphoneserviceapp.repositories;

import com.diegoaravena.cellphoneserviceapp.models.otherclass.RefreshToken;
import com.diegoaravena.cellphoneserviceapp.models.otherclass.WorkorderRepairCellphone;
import com.diegoaravena.cellphoneserviceapp.models.superclass.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RepositoryRestResource
public interface WorkorderRepairCellphoneRepository extends JpaRepository<WorkorderRepairCellphone, Long> {
    @Repository
    interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
        Optional<RefreshToken> findByToken(String token);

        @Modifying
        int deleteByUser(User user);
    }
}
