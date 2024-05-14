package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.CommandeComponent;
import fr.uga.l3miage.integrator.mappers.CommandeMapper;
import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import fr.uga.l3miage.integrator.requests.CommandeUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandeService {
    private final CommandeComponent commandeComponent;
    private final CommandeMapper commandeMapper;

    public List<CommandeResponseDTO> getAllCommandes() {
        return commandeComponent.getAllCommandes()
                .stream()
                .map(commandeMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public CommandeResponseDTO getCommandeByReference(String reference) {
        CommandeEntity entity = commandeComponent.getCommandeByReference(reference);
        return commandeMapper.entityToDto(entity);
    }

    public CommandeResponseDTO updateCommande(String reference, CommandeUpdateRequest updateRequest) {
        CommandeEntity entity = commandeComponent.getCommandeByReference(reference);
        if (entity != null) {
            CommandeEntity updatedEntity = commandeMapper.updateRequestToEntity(updateRequest);
            updatedEntity.setReference(reference);

            updatedEntity = commandeComponent.updateCommande(reference, updatedEntity);//!!!appel récursive d'un objet, et aussi implémentation pas juste selon moi

            updatedEntity = commandeComponent.updateCommande(reference, updatedEntity);

            return commandeMapper.entityToDto(updatedEntity);
        }
        throw new IllegalArgumentException("Commande with reference " + reference + " not found");
    }

}
