package fr.uga.l3miage.integrator.endpoints;

import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import fr.uga.l3miage.integrator.responses.LivraisonResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/livraisons")
public interface LivraisonEndpoint {

    @Operation(description = "Récupérer toutes les livraisons")
    @ApiResponse(responseCode = "200", description = "Liste des livraisons récupérée avec succès")
    @GetMapping
    ResponseEntity<List<LivraisonResponseDTO>> getAllLivraisons();

    @Operation(description = "Récupérer les commandes associées à une livraison")
    @ApiResponse(responseCode = "200", description = "Commandes récupérées avec succès")
    @GetMapping("/{reference}/commandes")
    ResponseEntity<List<CommandeResponseDTO>> getCommandesByLivraison(@PathVariable String reference);
}
