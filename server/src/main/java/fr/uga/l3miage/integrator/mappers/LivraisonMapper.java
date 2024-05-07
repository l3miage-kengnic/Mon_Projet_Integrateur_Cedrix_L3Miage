package fr.uga.l3miage.integrator.mappers;

import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.models.LivraisonEntity;
import fr.uga.l3miage.integrator.requests.LivraisonCreationRequest;
import fr.uga.l3miage.integrator.responses.LivraisonResponseDTO;
import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface LivraisonMapper {


     LivraisonEntity toEntity(LivraisonCreationRequest livraisonCreationRequest);


    //public LivraisonResponseDTO toEntity(LivraisonEntity livraisonEntity);




    /*
    @Mapping(source = "reference", target = "reference")
    @Mapping(source = "etat", target = "etat")
    @Mapping(source = "montant", target = "montant")
    @Mapping(source = "distanceAParcourir", target = "distanceAParcourir")
    @Mapping(source = "heureDeLivraisonTheorique", target = "heureDeLivraisonTheorique")
    @Mapping(source = "heureDeLivraisonEffective", target = "heureDeLivraisonEffective")
    LivraisonResponseDTO entityToDto(LivraisonEntity livraisonEntity);

    @Mapping(source = "reference", target = "reference")
    @Mapping(source = "etat", target = "etat")
    @Mapping(source = "montant", target = "montant")
    @Mapping(source = "distanceAParcourir", target = "distanceAParcourir")
    @Mapping(source = "heureDeLivraisonTheorique", target = "heureDeLivraisonTheorique")
    @Mapping(source = "heureDeLivraisonEffective", target = "heureDeLivraisonEffective")
    LivraisonEntity dtoToEntity(LivraisonResponseDTO livraisonResponseDTO);

    @Mapping(source = "reference", target = "reference")
    @Mapping(source = "etat", target = "etat")
    @Mapping(source = "dateDeCommande", target = "dateDeCommande")
    @Mapping(source = "montant", target = "montant")
    CommandeResponseDTO commandeEntityToCommandeResponseDTO(CommandeEntity commandeEntity);


*/
}