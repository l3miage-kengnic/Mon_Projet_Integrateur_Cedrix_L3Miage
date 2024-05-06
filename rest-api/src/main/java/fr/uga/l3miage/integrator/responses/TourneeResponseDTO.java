package fr.uga.l3miage.integrator.responses;

import fr.uga.l3miage.integrator.enums.EtatsDeTournee;
import lombok.Data;

@Data
public class TourneeResponseDTO {
    private String reference;  // Référence de la tournée
    private EtatsDeTournee etat;  // État de la tournée
    private String lettre;  // Lettre identifiant la tournée
    private double montant;  // Montant total de la tournée
    private int tdmTheorique;  // Temps de montage théorique
    private int tdmEffectif;  // Temps de montage effectif
    private double distanceAParcourir;  // Distance totale de la tournée
    private double distanceDeRetour;  // Distance pour retourner à l'entrepôt
}
