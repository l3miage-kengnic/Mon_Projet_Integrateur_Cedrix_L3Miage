package fr.uga.l3miage.integrator.endpoints;


import fr.uga.l3miage.integrator.requests.JourneeCreationRequest;
import fr.uga.l3miage.integrator.requests.JourneeUpdateRequest;
import fr.uga.l3miage.integrator.responses.JourneeResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/journees")
public interface JourneeEndpoint {

    @Operation(description = "Obtenir une journée par sa référence")
    @ApiResponse(
            responseCode = "200",
            description = "Journée récupérée avec succès",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = JourneeResponseDTO.class)
            )
    )
    @GetMapping("/{reference}")
    ResponseEntity<JourneeResponseDTO> getJourneeByReference(@PathVariable("reference") String reference);

    @Operation(description = "Créer une journée")
    @ApiResponse(
            responseCode = "201",
            description = "Journée créée avec succès"
    )
    @PostMapping
    ResponseEntity<Void> createJournee(@RequestBody JourneeCreationRequest creationRequest);

    @Operation(description = "Mettre à jour une journée")
    @ApiResponse(
            responseCode = "200",
            description = "Journée mise à jour avec succès"
    )
    @PutMapping("/{reference}")
    ResponseEntity<Void> updateJournee(@PathVariable("reference") String reference,
                                       @RequestBody JourneeUpdateRequest updateRequest);
}

