package fr.uga.l3miage.integrator.requests;

import lombok.Builder;
import lombok.Data;
import fr.uga.l3miage.integrator.enums.EtatsDeCommande;

@Data
@Builder
public class CommandeUpdateRequest {
    private String reference; // ajouté reference
    private EtatsDeCommande etat;
    private String commentaire;
    private double montant;
    private int tddTheorique;
    private int tdmTheorique;
}
//