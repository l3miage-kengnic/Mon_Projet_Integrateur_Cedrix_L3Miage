package fr.uga.l3miage.integrator.repositories;

import fr.uga.l3miage.integrator.enums.EtatsDeCommande;
import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.models.LivraisonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CommandeRepository extends JpaRepository<CommandeEntity, String> {
    Set<CommandeEntity> getAllByEtat( EtatsDeCommande etat);
}
