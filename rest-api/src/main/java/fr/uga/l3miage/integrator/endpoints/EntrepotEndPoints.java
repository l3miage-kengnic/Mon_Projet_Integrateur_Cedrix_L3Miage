/*package fr.uga.l3miage.integrator.endpoints;

import fr.uga.l3miage.integrator.responses.EntrepotResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Annotation pour indiquer que cette classe est un contrôleur REST
@RestController
@CrossOrigin(origins = "http://localhost:8080")
// Annotation pour définir la route de base pour tous les endpoints
@RequestMapping("/entrepots")
public interface EntrepotEndPoints {

    @Operation(description = "Récupérer tous les entrepôts")
    @ApiResponse(
            responseCode = "200",
            description = "Liste de tous les entrepôts récupérée avec succès",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EntrepotResponseDTO.class)
            )
    )
    @GetMapping
    ResponseEntity<List<EntrepotResponseDTO>> getAllEntrepots();

    @Operation(description = "Récupérer un entrepôt par son identifiant")
    @ApiResponse(
            responseCode = "200",
            description = "Entrepôt récupéré avec succès",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EntrepotResponseDTO.class)
            )
    )
    @GetMapping("/{id}")
    ResponseEntity<EntrepotResponseDTO> getEntrepotById(@PathVariable("id") String id);

    @Operation(description = "Créer un nouvel entrepôt")
    @ApiResponse(
            responseCode = "201",
            description = "Entrepôt créé avec succès",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EntrepotResponseDTO.class)
            )
    )
    @PostMapping
    ResponseEntity<EntrepotResponseDTO> createEntrepot(@RequestBody EntrepotResponseDTO entrepot);

    @Operation(description = "Mettre à jour un entrepôt par son identifiant")
    @ApiResponse(
            responseCode = "200",
            description = "Entrepôt mis à jour avec succès",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EntrepotResponseDTO.class)
            )
    )
    @PutMapping("/{id}")
    ResponseEntity<EntrepotResponseDTO> updateEntrepot(
            @PathVariable("id") String id,
            @RequestBody EntrepotResponseDTO entrepot);

    @Operation(description = "Supprimer un entrepôt par son identifiant")
    @ApiResponse(
            responseCode = "204",
            description = "Entrepôt supprimé avec succès",
            content = @Content(
                    mediaType = "application/json"
            )
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEntrepot(@PathVariable("id") String id);
}
*/