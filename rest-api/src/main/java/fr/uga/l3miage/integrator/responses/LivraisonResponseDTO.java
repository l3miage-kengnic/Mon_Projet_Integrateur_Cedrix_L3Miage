package fr.uga.l3miage.integrator.responses;

import fr.uga.l3miage.integrator.enums.EtatsDeLivraison;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class LivraisonResponseDTO {  // va servir pour renvoyer un objet Livraison au navigateur, avec le client lié

    private String reference;
    //private String etat;  utile à renvoyer?
    private Float montant;

    private Set<String> commandesResponse;

}
