package fr.uga.l3miage.integrator.endpoints;

import fr.uga.l3miage.integrator.responses.TourneeResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Tag(name = "Getsion Tournées")
@RequestMapping("/tournees")
public interface TourneeEndpoints {

    @GetMapping("/getAll/referenTournee")
    @ResponseStatus(HttpStatus.OK)
    Set<TourneeResponseDTO> getTourneeByReference( @RequestParam String reference);
}
