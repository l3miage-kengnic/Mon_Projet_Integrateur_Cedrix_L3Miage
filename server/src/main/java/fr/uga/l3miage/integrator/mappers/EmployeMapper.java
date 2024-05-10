package fr.uga.l3miage.integrator.mappers;

import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.responses.EmployeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/*@Mapper(componentModel = "spring")
public interface EmployeMapper {

    // Convertit un EmployeEntity en EmployeResponseDTO
    @Mapping(source = "trigramme", target = "trigramme")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "telephone", target = "telephone")
    @Mapping(source = "emploi", target = "emploi")
    @Mapping(source = "photo", target = "photo")
    EmployeResponseDTO entityToDto(EmployeEntity employeEntity);

    // Convertit un EmployeResponseDTO en EmployeEntity
    @Mapping(source = "trigramme", target = "trigramme")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "telephone", target = "telephone")
    @Mapping(source = "emploi", target = "emploi")
    @Mapping(source = "photo", target = "photo")
    EmployeEntity dtoToEntity(EmployeResponseDTO employeResponseDTO);
}
*/
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.responses.EmployeResponseDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.responses.EmployeResponseDTO;

@Mapper(componentModel = "spring")
public interface EmployeMapper {

    // Convertir EmployeEntity en EmployeResponseDTO
    @Mapping(source = "trigramme", target = "trigramme")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "telephone", target = "telephone")
    @Mapping(source = "emploi", target = "emploi")
    /*** @Mapping(source = "photo", target = "photo") ***/
    @Mapping(source = "entrepotEntity.name", target = "entrepot") // Correction du nom
    EmployeResponseDTO entityToDto(EmployeEntity employeEntity);

    // Convertir EmployeResponseDTO en EmployeEntity
    @Mapping(source = "trigramme", target = "trigramme")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "telephone", target = "telephone")
    @Mapping(source = "emploi", target = "emploi")
    /**@Mapping(source = "photo", target = "photo") ***/
    @Mapping(source = "entrepot", target = "entrepotEntity.name") // Correction du nom
    EmployeEntity dtoToEntity(EmployeResponseDTO employeResponseDTO);
}
