package fr.uga.l3miage.integrator.mappers;

<<<<<<< HEAD
import fr.uga.l3miage.integrator.DataType.Adresse;
import fr.uga.l3miage.integrator.models.EntrepotEntity;
import fr.uga.l3miage.integrator.responses.EntrepotResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntrepotMapper {

    //@Mapping(source = "employeEntity", target = "employe")
    //@Mapping(source = "camionEntities", target = "camions")
    @Mapping(source = "employeEntity.trigramme", target = "employeEntityTrigramme")

    EntrepotResponseDTO entityToDto(EntrepotEntity entity);
    Adresse dtoToEntity(Adresse adresse);
    EntrepotEntity dtoToEntity(EntrepotResponseDTO dto);

=======
import fr.uga.l3miage.integrator.models.EntrepotEntity;
import fr.uga.l3miage.integrator.responses.EntrepotResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntrepotMapper {
    EntrepotResponseDTO entityToDto(EntrepotEntity entity);
>>>>>>> e10fd43872720309e2176afdd436d2f2188e1ee1
}
