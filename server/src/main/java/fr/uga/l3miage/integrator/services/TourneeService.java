package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.Mappers.TourneeMapper;
import fr.uga.l3miage.integrator.components.TourneeComponent;
import fr.uga.l3miage.integrator.exceptions.rest.NotFoundEntityRestException;
import fr.uga.l3miage.integrator.exceptions.technical.NotFoundTourneeEntityException;
import fr.uga.l3miage.integrator.models.TourneeEntity;
import fr.uga.l3miage.integrator.responses.TourneeResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TourneeService {

    private final TourneeComponent tourneeComponent;
    @Autowired   // Est-ce utile??
    TourneeMapper tourneeMapper;

    public TourneeResponseDTO getTourneeByReference(String reference) throws NotFoundTourneeEntityException {

        try {
            TourneeResponseDTO tourneesDTO;
            tourneesDTO = new TourneeResponseDTO();
            TourneeEntity tourneeEntity;
            tourneeEntity = tourneeComponent.getTourneeEntityByReference(reference);
            tourneeMapper.toResponseDTO(tourneeEntity);

            return tourneesDTO;
        }catch (NotFoundTourneeEntityException e){
            throw new NotFoundEntityRestException(e.getMessage());
        }


    }
}
