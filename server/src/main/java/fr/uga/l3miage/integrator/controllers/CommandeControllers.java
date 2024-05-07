package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.endpoints.CommandeEndpoints;
import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import fr.uga.l3miage.integrator.responses.ResponsesFinaux.CommandeResponseDTOFinal;
import fr.uga.l3miage.integrator.services.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
@RequiredArgsConstructor
public class CommandeControllers implements CommandeEndpoints {
    private  final CommandeService commandeService;

    @Override
    public Set<CommandeResponseDTOFinal> getCommandesPlanifiees(){
        return commandeService.getCommandesPlanifiees();
    }

}
