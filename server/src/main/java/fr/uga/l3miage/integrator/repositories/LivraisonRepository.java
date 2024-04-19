package fr.uga.l3miage.integrator.repositories;

import fr.uga.l3miage.integrator.models.LivraisonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivraisonRepository extends JpaRepository<LivraisonEntity, String> {
}
