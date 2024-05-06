package fr.uga.l3miage.integrator.errors;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NotFoundErrorResponse {
    @Schema(description = "end point call", example = "/api/tournees")
    private  final String uri;
    @Schema(description = "error message", example = "la tournée cherchée n'éxiste pas")
    private final String errorMessage;
}
