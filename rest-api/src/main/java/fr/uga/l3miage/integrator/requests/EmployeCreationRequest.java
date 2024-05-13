package fr.uga.l3miage.integrator.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Requete de creation d'un employé")
public class EmployeCreationRequest {
    @Schema(description = "un employé est soit livreur, soit planificateur")
    private String emploi;
    @Schema(description = "entrepot à partir de la quelle la tourné")
    private  String entrepot;
}
