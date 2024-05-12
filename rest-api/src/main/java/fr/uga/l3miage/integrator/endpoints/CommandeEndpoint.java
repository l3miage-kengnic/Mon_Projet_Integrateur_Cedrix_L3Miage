package fr.uga.l3miage.integrator.endpoints;

import fr.uga.l3miage.integrator.requests.CommandeUpdateRequest;
import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/commandes")
public interface CommandeEndpoint {

    @Operation(description = "Obtenir toutes les commandes")
    @ApiResponse(
            responseCode = "200",
            description = "Liste des commandes récupérée avec succès",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CommandeResponseDTO.class)  //**!! Attention, doit retourner un Set *****
            )
    )
    @GetMapping
    ResponseEntity<List<CommandeResponseDTO>> getAllCommandes();

    @Operation(description = "Obtenir une commande par sa référence")
    @ApiResponse(
            responseCode = "200",
            description = "Commande récupérée avec succès",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CommandeResponseDTO.class) //**!! Attention, doit retourner un Set *****
            )
    )
    @GetMapping("/{reference}")
    ResponseEntity<CommandeResponseDTO> getCommandeByReference(@PathVariable("reference") String reference);

    @Operation(description = "Mettre à jour une commande")
    @ApiResponse(
            responseCode = "200",
            description = "Commande mise à jour avec succès",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CommandeResponseDTO.class)  //**!! Attention, doit retourner un Set *****
            )
    )
    @PutMapping("/{reference}")
    ResponseEntity<CommandeResponseDTO> updateCommande(@PathVariable("reference") String reference,
                                                       @RequestBody CommandeUpdateRequest updateRequest);
}
//