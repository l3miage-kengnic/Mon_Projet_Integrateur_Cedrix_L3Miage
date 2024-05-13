package fr.uga.l3miage.integrator.mappers;

import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import fr.uga.l3miage.integrator.requests.CommandeUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommandeMapper {
    CommandeResponseDTO entityToDto(CommandeEntity entity);
    CommandeEntity DtoToEntity(CommandeResponseDTO commandeResponseDTO);//************

    @Mapping(target = "reference", ignore = true)
    CommandeEntity updateRequestToEntity(CommandeUpdateRequest updateRequest);

    /*@Mapping(target = "adresseClient", source = "clientEntity.adresse") // Ajoutez ceci
    CommandeResponseDTO entityToDtoWithAddress(CommandeEntity entity);*/

}
