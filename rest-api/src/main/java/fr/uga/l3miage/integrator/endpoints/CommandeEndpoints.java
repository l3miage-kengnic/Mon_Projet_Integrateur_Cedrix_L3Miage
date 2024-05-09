package fr.uga.l3miage.integrator.endpoints;

import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import fr.uga.l3miage.integrator.responses.ResponsesFinaux.CommandeResponseDTOFinal;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Tag(name="Gestion des commandes")
@RestController
@RequestMapping("/api/commandes")
public interface CommandeEndpoints {


    @GetMapping("/getPlanifiees") // requette http: .../api/commandes/getPlanifiees
    @ResponseStatus(HttpStatus.OK)
    // Toutes les commandes planifiées:
    Set<CommandeResponseDTOFinal> getCommandesPlanifiees(); // ne prend aucun paramètre, et renvoie des DTO des commandes en BD

    @GetMapping("/getAll") // requette http: .../api/commandes/getAll
    @ResponseStatus(HttpStatus.OK)
    // Toutes les commandes en BD
    Set<CommandeResponseDTOFinal> getAllCommandes();

}
