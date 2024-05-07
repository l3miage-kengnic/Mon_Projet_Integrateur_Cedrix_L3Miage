package fr.uga.l3miage.integrator.responses;

import fr.uga.l3miage.integrator.enums.EtatsDeLivraison;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;


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


/**
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
   *****/