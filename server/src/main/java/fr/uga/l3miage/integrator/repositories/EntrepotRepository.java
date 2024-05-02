package fr.uga.l3miage.integrator.repositories;

import fr.uga.l3miage.integrator.models.EntrepotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepotRepository extends JpaRepository<EntrepotEntity, String> {
    Optional<EntrepotEntity> findByName(String name);

}
