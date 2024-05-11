package fr.uga.l3miage.integrator.requests;

import lombok.Data;
import fr.uga.l3miage.integrator.enums.EtatsDeCommande;

@Data
public class CommandeUpdateRequest {
    private EtatsDeCommande etat;
    private String commentaire;
    private double montant;
    private int tddTheorique;
    private int tdmTheorique;
}
