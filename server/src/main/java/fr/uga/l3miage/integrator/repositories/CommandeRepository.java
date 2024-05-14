package fr.uga.l3miage.integrator.repositories;

import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.models.LivraisonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository // ajouté Repository
public interface CommandeRepository extends JpaRepository<CommandeEntity, String> {

}
