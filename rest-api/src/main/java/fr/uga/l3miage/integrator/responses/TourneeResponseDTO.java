package fr.uga.l3miage.integrator.responses;

import fr.uga.l3miage.integrator.enums.EtatsDeTournee;
import io.swagger.v3.oas.annotations.media.Schema;
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
