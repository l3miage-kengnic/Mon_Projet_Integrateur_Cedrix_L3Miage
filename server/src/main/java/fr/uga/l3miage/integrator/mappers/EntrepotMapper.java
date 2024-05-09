package fr.uga.l3miage.integrator.mappers;

import fr.uga.l3miage.integrator.models.EntrepotEntity;
import fr.uga.l3miage.integrator.responses.EntrepotResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntrepotMapper {
    EntrepotResponseDTO entityToDto(EntrepotEntity entity);
}
