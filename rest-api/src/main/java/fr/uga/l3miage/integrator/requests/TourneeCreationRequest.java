package fr.uga.l3miage.integrator.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;  // Validation des chaînes non vides
import javax.validation.constraints.NotNull;  // Validation des valeurs non nulles

@Data
public class TourneeCreationRequest {


    private String nom;
    private String description;
    // Ajoutez d'autres champs pour la mise à jour de la tournée
/*

    @NotBlank
    private String reference;  // Référence unique de la tournée

    @NotBlank
    private String lettre;  // Lettre de la tournée

    @NotNull
    private double montant;  // Montant total

    @NotNull
    private int tdmTheorique;  // Temps de montage théorique

    @NotNull
    private double distanceAParcourir;  // Distance totale

    @NotNull
    private double distanceDeRetour;  // Distance de retour

    @NotBlank
    private String camionReference;  // Référence du camion associé

    @NotBlank
    private String journeeReference;  // Référence de la journée associée*/
}

