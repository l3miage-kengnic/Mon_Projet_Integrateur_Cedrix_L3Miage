package fr.uga.l3miage.integrator.repositories;

import fr.uga.l3miage.integrator.models.LivraisonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivraisonRepository extends JpaRepository<LivraisonEntity, String> {

    //List<LivraisonEntity> findByEtat(String etat); // Exemple : Récupérer les livraisons par état

}
