package fr.uga.l3miage.integrator.responses;

import fr.uga.l3miage.integrator.enums.EtatsDeTournee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import lombok.Data;
import java.util.Set;

@Data
@Schema(description = "description de Tournee")
public class TourneeResponseDTO {

    @Schema(description = "reference d'une Tournee")
    private String reference;
    @Schema(description = "l'état d'une Tournee")
    private EtatsDeTournee etat;
    @Schema(description = "lettre referente d'une Tournee")
    private String lettre;
    @Schema(description = "somme des montant de chaque livraison  de la Tournee")
    private String montant;

    private Set<LivraisonResponseDTO> livraisons;
}


/**
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
***/