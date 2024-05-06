package fr.uga.l3miage.integrator.Mappers;

import fr.uga.l3miage.integrator.models.LivraisonEntity;
import fr.uga.l3miage.integrator.requests.LivraisonCreationRequest;
import fr.uga.l3miage.integrator.responses.LivraisonResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface LivraisonMapper {

    @Mapping(target = "LivraisonEntity")
    public LivraisonEntity toEntity(LivraisonCreationRequest livraisonCreationRequest);

    @Mapping(target = "LivraisonResponseDTO")
    public LivraisonResponseDTO toEntity(LivraisonEntity livraisonEntity);
}
