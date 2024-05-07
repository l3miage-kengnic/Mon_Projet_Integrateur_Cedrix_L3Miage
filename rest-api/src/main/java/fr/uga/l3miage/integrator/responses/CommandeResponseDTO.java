package fr.uga.l3miage.integrator.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.Date;
import java.util.Set;

import fr.uga.l3miage.integrator.enums.EtatsDeCommande;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "description structure intermédiaire pour renvoyer une commandes")
public class CommandeResponseDTO {

    @Schema(description = "reference de la commande")
    private String reference;
    @Schema(description = "état de la commande: ouverte, livrable ou livree")
    private String etat;
    @Schema(description = "date à la quelle la commande a été passé: elle passe à l'état planifiée")
    private String date;
    @Schema(description = "montant total de la commande")
    private String montant;

    @Schema(description = "client ayant passé la commande")
    private ClientResponseDTO clientResponseDTO;
    @Schema(description = "produit")
    private EmployeResponseDTO employeResponseDTO;
    @Schema(description = "lignes referençant les produit de la commande")
    private Set<LigneResponseDTO> lignesResponseDTOSet;

}




/*

@Data
@Schema(name = "CommandeResponseDTO", description = "Commande response")
public class CommandeResponseDTO {
    private String reference;
    private EtatsDeCommande etat;
    private Date dateDeCommande;
    private double montant;
}
   ***/