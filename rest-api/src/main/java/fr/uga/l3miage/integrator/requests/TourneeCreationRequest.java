package fr.uga.l3miage.integrator.requests;

import fr.uga.l3miage.integrator.enums.EtatsDeTournee;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TourneeCreationRequest {

    private String reference;
    private String etat;
    private String lettre;
    private String montant;

    private Set<LivraisonCreationRequest> livraisons;
}
