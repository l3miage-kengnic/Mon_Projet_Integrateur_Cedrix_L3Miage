package fr.uga.l3miage.integrator.repositories;

import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EmployeRepository extends JpaRepository<EmployeEntity,String> {
    //EmployeEntity findByEmail(String email);
    Set<EmployeEntity> findAllByEmploi(Emploi emploi);
    //EmployeEntity findByTrigramme(String trigramme);
}

