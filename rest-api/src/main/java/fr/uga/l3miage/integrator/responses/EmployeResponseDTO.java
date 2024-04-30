package fr.uga.l3miage.integrator.responses;

import fr.uga.l3miage.integrator.enums.Emploi;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "EmployeResponseDTO", description = "Employe response")
public class EmployeResponseDTO {
    @Schema(description = "Trigramme de l'employé")
    private String trigramme;

    @Schema(description = "Email de l'employé")
    private String email;

    @Schema(description = "Prénom de l'employé")
    private String prenom;

    @Schema(description = "Nom de l'employé")
    private String nom;

    @Schema(description = "Numéro de téléphone de l'employé")
    private String telephone;

    @Schema(description = "Emploi ou rôle de l'employé")
    private Emploi emploi;
    @Schema(description = "Photo")
    private String photo;
}
