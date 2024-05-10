package fr.uga.l3miage.integrator.errors;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeErrorResponse {
    @Schema(description = "URI appelée", example = "/api/v1/employes")
    private final String uri;

    @Schema(description = "Message d'erreur", example = "Aucun employé trouvé")
    private final String errorMessage;

    // Définissez le constructeur comme public
    public EmployeErrorResponse(String uri, String errorMessage) {
        this.uri = uri;
        this.errorMessage = errorMessage;
    }
}
//