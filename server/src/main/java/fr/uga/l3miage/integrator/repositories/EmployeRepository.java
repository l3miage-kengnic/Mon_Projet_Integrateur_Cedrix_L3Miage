package fr.uga.l3miage.integrator.repositories;

import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.models.EntrepotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface EmployeRepository extends JpaRepository<EmployeEntity,String> {
    Set<EmployeEntity> findAllByEmploi(Emploi emploi);

}

