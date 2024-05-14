package fr.uga.l3miage.integrator.mappers;

import fr.uga.l3miage.integrator.models.CamionEntity;
import fr.uga.l3miage.integrator.responses.CamionResponseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CamionMapper {

    CamionResponseDTO entityToDto(CamionEntity entity);

}
