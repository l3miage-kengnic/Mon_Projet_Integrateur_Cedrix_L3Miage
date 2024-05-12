package fr.uga.l3miage.integrator.responses;

import fr.uga.l3miage.integrator.enums.EtatsDeLivraison;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(name = "LivraisonResponseDTO", description = "Livraison response")
public class LivraisonResponseDTO {
    private String reference;
    private EtatsDeLivraison etat;
    private Float montant;
    private Float distanceAParcourir;
    private Date heureDeLivraisonTheorique;
    private Date heureDeLivraisonEffective;
}
//