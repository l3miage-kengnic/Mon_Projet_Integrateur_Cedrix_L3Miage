package fr.uga.l3miage.integrator.requests;

import lombok.Data;

import javax.validation.constraints.NotNull;  // Pour la validation des valeurs non nulles

@Data
public class TourneeUpdateRequest {
    /*private double montant;  // Montant mis à jour

    private int tdmTheorique;  // Temps de montage théorique mis à jour

    private double distanceAParcourir;  // Distance totale mise à jour

    private double distanceDeRetour;  // Distance de retour mise à jour*/


        private String nom;
        private String description;


}
//