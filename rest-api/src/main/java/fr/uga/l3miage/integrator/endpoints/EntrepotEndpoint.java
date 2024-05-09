package fr.uga.l3miage.integrator.endpoints;

import fr.uga.l3miage.integrator.responses.EntrepotResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrepots")
@CrossOrigin(origins = "http://localhost:8080")
public interface EntrepotEndpoint {

    @Operation(description = "Récupérer tous les entrepôts")
    @ApiResponse(
            responseCode = "200",
            description = "Tous les entrepôts récupérés avec succès",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EntrepotResponseDTO.class)
            )
    )
    @GetMapping
    ResponseEntity<List<EntrepotResponseDTO>> getAllEntrepots();
}
