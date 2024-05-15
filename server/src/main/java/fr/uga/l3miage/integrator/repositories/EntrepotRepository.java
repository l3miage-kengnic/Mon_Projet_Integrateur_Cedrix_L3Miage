package fr.uga.l3miage.integrator.repositories;

import fr.uga.l3miage.integrator.models.EntrepotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepotRepository extends JpaRepository<EntrepotEntity, String> {
    EntrepotEntity findByName(String name);

}
