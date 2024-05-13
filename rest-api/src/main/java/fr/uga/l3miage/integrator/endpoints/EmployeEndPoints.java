package fr.uga.l3miage.integrator.endpoints;

import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.responses.EmployeResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
// Annotation pour indiquer que cette classe est un contrôleur REST
@RestController
// Annotation pour permettre des requêtes cross-origin depuis "http://localhost:8080"
@CrossOrigin(origins = "http://localhost:8080")
// Annotation pour définir la route de base pour tous les endpoints
@RequestMapping("/employes")
public interface EmployeEndPoints {
    // Annotation pour décrire l'opération dans Swagger
    @Operation(description = "Récupérer tous les employés")
    // Annotation pour indiquer la réponse de cette opération
    @ApiResponse(
            responseCode = "200",// Le code de réponse attendu (200 pour succès)
            description = "La liste de tous les employés a été récupérée avec succès",// Description de la réponse
            content = @Content(
                    mediaType = "application/json",// Type de contenu attendu (JSON)
                    schema = @Schema(implementation = EmployeResponseDTO.class)// Schéma de la réponse, indiquant le type d'objet attendu
            )
    )
    // Annotation pour définir une méthode de type GET
    @GetMapping
    // Cette méthode récupère tous les employés et retourne une réponse HTTP contenant une liste d'EmployeResponseDTO
    ResponseEntity<List<EmployeResponseDTO>> getAllEmployes();

    // Annotation pour décrire une opération pour récupérer tous les livreurs
    /*@Operation(description = "Récupérer la liste des livreurs")
    @ApiResponse(
            responseCode = "200",
            description = "La liste des livreurs a été récupérée avec succès",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EmployeResponseDTO.class)
            )
    )
    // Annotation pour indiquer le statut HTTP de cette méthode
    @ResponseStatus(HttpStatus.OK)
    // Annotation pour définir le chemin de cette route (utilise RequestMapping au lieu de GetMapping, ce qui permettrait d'utiliser différentes méthodes HTTP si nécessaire)
    @RequestMapping("/livreurs")
    // Cette méthode récupère la liste des livreurs et retourne un ensemble d'EmployeResponseDTO
    Set<EmployeResponseDTO> getAllLivreurs();


    // Annotation pour décrire une opération pour récupérer des employés selon leur rôle
    @Operation(description = "Récupérer les employés par rôle")
    @ApiResponse(
            responseCode = "200",
            description = "Les employés selon le rôle ont été récupérés avec succès",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EmployeResponseDTO.class)
            )
    )
    @ResponseStatus(HttpStatus.OK)
    // Annotation pour définir le chemin de cette route avec une variable (PathVariable) qui indique le rôle de l'employé
    @GetMapping("/{emploi}")
    // Cette méthode prend un paramètre d'entrée `emploi` et récupère tous les employés avec ce rôle. Retourne un ensemble d'EmployeResponseDTO
    Set<EmployeResponseDTO> getEmployesByRole(@PathVariable("emploi") Emploi emploi);*/
    @GetMapping("/{emploi}")
    Set<EmployeResponseDTO> getEmployesByRole(@PathVariable("emploi") String emploi);
    
}
//