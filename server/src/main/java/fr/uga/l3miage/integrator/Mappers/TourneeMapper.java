package fr.uga.l3miage.integrator.Mappers;

import fr.uga.l3miage.integrator.models.LivraisonEntity;
import fr.uga.l3miage.integrator.models.TourneeEntity;
import fr.uga.l3miage.integrator.requests.LivraisonCreationRequest;
import fr.uga.l3miage.integrator.requests.TourneeCreationRequest;
import fr.uga.l3miage.integrator.responses.TourneeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper
public interface TourneeMapper {

    @Mapping(target = "to TourneeResponseDTO")
    public TourneeResponseDTO toResponseDTO(TourneeEntity tourneeEntity);

    @Mapping(target = "to TourneeEntity")
    public TourneeEntity toEntity(TourneeCreationRequest tourneeCreationRequest);
}
