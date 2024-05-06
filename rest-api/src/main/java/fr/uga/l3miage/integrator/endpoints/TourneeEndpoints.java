package fr.uga.l3miage.integrator.endpoints;

import fr.uga.l3miage.integrator.requests.TourneeCreationRequest;
import fr.uga.l3miage.integrator.responses.TourneeResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Tag(name = "Getsion Tournées")
@RequestMapping("/api/tournees")
public interface TourneeEndpoints {

    @Operation(description = "Récuperer une tournée")
    @ApiResponse(responseCode = "200",description = "Le son à été ajouté à la playlist") //***********
    @ApiResponse(responseCode = "404", description = "la playlist ou le son demandée n'a pas été trouvé",content = @Content(schema = @Schema(implementation = AddPlaylistErrorResponse.class),mediaType = MediaType.APPLICATION_JSON_VALUE))
    @GetMapping("/getAll/{referenceTournee}")
    @ResponseStatus(HttpStatus.OK)
    TourneeResponseDTO getTourneeByReference( @PathVariable(name = "referenceTournee") String reference);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    TourneeResponseDTO creatTournee(@RequestBody TourneeCreationRequest tourneeCreationRequest);

}
