package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.CommandeComponent;
import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import fr.uga.l3miage.integrator.responses.ResponsesFinaux.CommandeResponseDTOFinal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CommandeService {
    private final CommandeComponent commandeComponent;

    public Set<CommandeResponseDTOFinal> getCommandesPlanifiees(){

        Set<CommandeResponseDTOFinal> commandesDTO =  Set.of();
        Set<CommandeEntity> commandeEntities;
        commandeEntities = commandeComponent.getAllCommandes();

        for( CommandeEntity c: commandeEntities){
            CommandeResponseDTOFinal commandeDTO = new CommandeResponseDTOFinal(); // DTO pour la commande en traitement
            //*****traitements attributs

            //************
            commandesDTO.add( commandeDTO); // on ajoute cette commande dans l'ensemble des commandes DTO
        }

        return commandesDTO;
    }
}
