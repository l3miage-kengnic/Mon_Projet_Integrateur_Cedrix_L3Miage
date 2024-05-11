package fr.uga.l3miage.integrator.mappers;

import fr.uga.l3miage.integrator.models.TourneeEntity;
import fr.uga.l3miage.integrator.responses.TourneeResponseDTO;
import fr.uga.l3miage.integrator.requests.TourneeCreationRequest;
import fr.uga.l3miage.integrator.requests.TourneeUpdateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TourneeMapper {
    TourneeResponseDTO entityToDto(TourneeEntity entity);

    TourneeEntity createRequestToEntity(TourneeCreationRequest request);

    TourneeEntity updateRequestToEntity(TourneeUpdateRequest request);
}
