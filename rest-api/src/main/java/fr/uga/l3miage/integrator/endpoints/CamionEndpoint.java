package fr.uga.l3miage.integrator.endpoints;

import fr.uga.l3miage.integrator.responses.CamionResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/camions")
public interface CamionEndpoint {

    @Operation(description = "Récupérer tous les camions")
    /***@ApiResponse(
            responseCode = "200",
            description = "Tous les camions récupérés avec succès",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = CamionResponseDTO.class, )
            )content = @Content(schema = @Schema(implementation = AddPlaylistErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE)
    )  *****/


    @ApiResponse(
            responseCode = "200",
            description = "Tous les camions récupérés avec succès",
            content = @Content(schema = @Schema(implementation = CamionResponseDTO.class),mediaType = MediaType.APPLICATION_JSON_VALUE)
    )


    @GetMapping("getAll")
    ResponseEntity<List<CamionResponseDTO>> getAllCamions();
}
