package fr.uga.l3miage.integrator.mappers;

import fr.uga.l3miage.integrator.models.CamionEntity;
import fr.uga.l3miage.integrator.responses.CamionResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CamionMapper {

    CamionResponseDTO entityToDto(CamionEntity entity);

}
