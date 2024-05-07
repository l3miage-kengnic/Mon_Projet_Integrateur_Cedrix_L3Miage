package fr.uga.l3miage.integrator.responses.ResponsesFinaux;

import fr.uga.l3miage.integrator.responses.ClientResponseDTO;
import fr.uga.l3miage.integrator.responses.EmployeResponseDTO;
import fr.uga.l3miage.integrator.responses.LigneResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Data
@Schema(description = "description structure finale pour renvoyer une commandes")
public class CommandeResponseDTOFinal {

    @Schema(description = "reference de la commande")
    private String reference;
    @Schema(description = "état de la commande: ouverte, livrable ou livree")
    private String etat;
    @Schema(description = "date à la quelle la commande a été passé: elle passe à l'état planifiée")
    private String date;
    @Schema(description = "montant total de la commande")
    private String montant;

    @Schema(description = "nom client ayant passé la commande")
    private String nomClient;
    @Schema(description = "prenom client ayant passé la commande")
    private String prenomClient;
    @Schema(description = "client ayant passé la commande")
    private String adresseClient;


    @Schema(description = "lignes referençant les produit de la commande")
    private Set<String> otionMontage;

    @Schema(description = "Liste des references des produits de la commande")
    private Set<String> referencesProduit;

    @Schema(description = "Liste des titres  des produits de la commande")
    private String titresProduit;

}
