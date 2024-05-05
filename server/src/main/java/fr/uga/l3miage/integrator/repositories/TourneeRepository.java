package fr.uga.l3miage.integrator.repositories;

import fr.uga.l3miage.integrator.models.TourneeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TourneeRepository extends JpaRepository<TourneeEntity, String> {
    Set<TourneeEntity> getByReference(String reference);
}
