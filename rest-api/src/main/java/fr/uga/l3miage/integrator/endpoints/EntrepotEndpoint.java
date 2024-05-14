package fr.uga.l3miage.integrator.endpoints;

import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import fr.uga.l3miage.integrator.responses.EntrepotResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrepots")

//@CrossOrigin(origins = "http://localhost:8080")

@CrossOrigin(origins = "http://localhost:8080")

//@CrossOrigin(origins = "http://localhost:8080")

public interface EntrepotEndpoint {

    @Operation(description = "Récupérer tous les entrepôts")
    @ApiResponse(
            responseCode = "200",
            description = "Tous les entrepôts récupérés avec succès",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = EntrepotResponseDTO.class)),mediaType = MediaType.APPLICATION_JSON_VALUE)
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("getAll")
    ResponseEntity<List<EntrepotResponseDTO>> getAllEntrepots();
}
