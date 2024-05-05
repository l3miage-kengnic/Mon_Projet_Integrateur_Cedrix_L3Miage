package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.TourneeComponent;
import fr.uga.l3miage.integrator.responses.TourneeResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TourneeService {

    private final TourneeComponent tourneeComponent;

    Set<TourneeResponseDTO> getTourneeByReference(String reference){
        Set<TourneeResponseDTO> tourneesDTO;
        tourneesDTO = Set.of();
        //....

        return tourneesDTO;

    }
}
