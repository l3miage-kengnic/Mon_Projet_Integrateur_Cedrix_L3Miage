package fr.uga.l3miage.integrator.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@Schema(description = "Requete de creation d'un employé")
public class EmployeCreationRequest {
    @Schema(description = "trigramme de l'employé")
    private String trigramme;
    @Schema(description = "nom de l'employe")
    private String nom;
    @Schema(description = "prenom de l'employe")
    private String prenom;
    @Schema(description = "photo de l'employe")
    private String photo;
    @Schema(description = "telephone de l'employe")
    private String telephone;
    @Schema(description = "un employé est soit livreur, soit planificateur")
    private String emploi;
    @Schema(description = "entrepot à partir de la quelle la tourné")
    private  String entrepot;
    @Schema(description = "tournée de l'employé si c'est un livreur")
    private Set<String> tournees;
}
