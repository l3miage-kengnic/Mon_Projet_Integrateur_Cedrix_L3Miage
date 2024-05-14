package fr.uga.l3miage.integrator.endpoints;

import fr.uga.l3miage.integrator.requests.TourneeCreationRequest;
import fr.uga.l3miage.integrator.requests.TourneeUpdateRequest;
import fr.uga.l3miage.integrator.responses.TourneeResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/tournees")
@Tag(name = "Tournee Endpoint", description = "Endpoints pour la gestion des tournées")
public interface TourneeEndpoint {

    @GetMapping("/{refTournee}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Récupérer une tournée par sa référence")
    @ApiResponse(responseCode = "200", description = "Tournée récupérée avec succès")
    ResponseEntity<TourneeResponseDTO> getTournee(@PathVariable String refTournee);


    @Operation(description = "Créer une nouvelle tournée")
    @ApiResponse(responseCode = "201", description = "Tournée créée avec succès")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    void createTournee(@RequestBody TourneeCreationRequest request);

    @PutMapping("/update/{refTournee}")
    @Operation(description = "Mettre à jour une tournée existante")
    @ApiResponse(responseCode = "200", description = "Tournée mise à jour avec succès")
    ResponseEntity<Void> updateTournee(@PathVariable("refTournee") String refTournee,
                                       @RequestBody TourneeUpdateRequest request);

    @DeleteMapping("/{refTournee}")
    @Operation(description = "Supprimer une tournée par sa référence")
    @ApiResponse(responseCode = "204", description = "Tournée supprimée avec succès")
    ResponseEntity<Void> deleteTournee(@PathVariable("refTournee") String refTournee);

}