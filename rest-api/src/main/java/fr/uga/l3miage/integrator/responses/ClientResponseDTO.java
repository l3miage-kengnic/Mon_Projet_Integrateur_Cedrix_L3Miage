package fr.uga.l3miage.integrator.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Set;

@Data
@Schema(description = "description d'un client")
public class ClientResponseDTO {  // ce DTO est pour une entité Client dont l'état est LIVRABLE

    @Schema(description = "adresse email du client")
    private String email;
    @Schema(description = "prenom du client")
    private String nom;
    @Schema(description = "adresse du client")
    private String adresse;
    @Schema(description = "Code Postal du client")
    private String codePostal;
    @Schema(description = "ville du client")
    private  String ville;

    //@Schema(description = "liste des commandes planifiées du client")
    //private Set<CommandeResponseDTO> commandes;

}
