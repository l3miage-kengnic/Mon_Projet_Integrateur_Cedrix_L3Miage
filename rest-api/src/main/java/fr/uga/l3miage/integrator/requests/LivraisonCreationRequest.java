package fr.uga.l3miage.integrator.requests;


import fr.uga.l3miage.integrator.responses.ClientResponseDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class LivraisonCreationRequest {
    private String reference;
    private String etat;
    private double montant;


}
