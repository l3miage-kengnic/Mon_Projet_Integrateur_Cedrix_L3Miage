package fr.uga.l3miage.integrator.mappers;

import fr.uga.l3miage.integrator.models.JourneeEntity;
import fr.uga.l3miage.integrator.requests.JourneeCreationRequest;
import fr.uga.l3miage.integrator.requests.JourneeUpdateRequest;
import fr.uga.l3miage.integrator.responses.JourneeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface JourneeMapper {

    JourneeResponseDTO entityToDto(JourneeEntity entity);

    JourneeEntity createRequestToEntity(JourneeCreationRequest request);
    @Mapping(target = "reference", ignore = true) // Ignorer la mise à jour de la référence
    JourneeEntity updateEntityFromRequest( JourneeUpdateRequest request);
}
