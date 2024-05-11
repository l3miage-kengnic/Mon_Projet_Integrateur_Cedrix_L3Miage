package fr.uga.l3miage.integrator.mappers;

import fr.uga.l3miage.integrator.models.ClientEntity;
import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.responses.ClientResponseDTO;
import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import fr.uga.l3miage.integrator.requests.CommandeUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    /*@Mapping(target = "clientEmail", expression = "java(mapClientEmail(entity))")
    CommandeResponseDTO entityToDto(CommandeEntity entity);

    default String mapClientEmail(CommandeEntity entity) {
        return entity.getClientEntity().getEmail();
    }

    @Mapping(target = "reference", ignore = true)
    CommandeEntity updateRequestToEntity(CommandeUpdateRequest updateRequest);*/

    /*@Mapping(target = "adresseClient", source = "clientEntity.adresse") // Ajoutez ceci
    CommandeResponseDTO entityToDtoWithAddress(CommandeEntity entity);*/


    @Mapping(target = "client", source = "entity.clientEntity")
    CommandeResponseDTO entityToDto(CommandeEntity entity);

    @Mapping(target = "reference", ignore = true)
    CommandeEntity updateRequestToEntity(CommandeUpdateRequest updateRequest);

    default ClientResponseDTO mapClientEntityToDto(ClientEntity entity) {
        if (entity == null) {
            return null;
        }
        ClientResponseDTO dto = new ClientResponseDTO();
        dto.setEmail(entity.getEmail());
        dto.setPrenom(entity.getPrenom());
        dto.setNom(entity.getNom());
        dto.setAdresse(entity.getAdresse());
        dto.setPosition(entity.getPosition());
        return dto;
    }

}
