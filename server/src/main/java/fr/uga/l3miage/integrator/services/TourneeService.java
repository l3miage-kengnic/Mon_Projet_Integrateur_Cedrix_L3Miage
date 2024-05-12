package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.mappers.TourneeMapper;
import fr.uga.l3miage.integrator.models.TourneeEntity;
import fr.uga.l3miage.integrator.responses.TourneeResponseDTO;
import fr.uga.l3miage.integrator.requests.TourneeCreationRequest;
import fr.uga.l3miage.integrator.requests.TourneeUpdateRequest;
import fr.uga.l3miage.integrator.components.TourneeComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TourneeService {

    private final TourneeComponent tourneeComponent;
    private final TourneeMapper tourneeMapper;

    public TourneeResponseDTO getTournee(String refTournee) {
        TourneeEntity entity = tourneeComponent.getTourneeByReference(refTournee);
        return tourneeMapper.entityToDto(entity);
    }

    public void createTournee(TourneeCreationRequest request) {
        TourneeEntity tourneeEntity = tourneeMapper.createRequestToEntity(request);
        tourneeComponent.createTournee(tourneeEntity);
    }

    public void updateTournee(String refTournee, TourneeUpdateRequest request) {
        TourneeEntity existingTournee = tourneeComponent.getTourneeByReference(refTournee);
        if (existingTournee != null) {
            TourneeEntity updatedTournee = tourneeMapper.updateRequestToEntity(request);
            tourneeComponent.updateTournee(refTournee, updatedTournee);
        }
    }

    public boolean deleteTournee(String refTournee) {
        TourneeEntity tournee = tourneeComponent.getTourneeByReference(refTournee);
        if (tournee != null) {
            tourneeComponent.deleteTournee(tournee);
            return true; // Suppression réussie
        } else {
            return false; // Tournée non trouvée
        }
    }
}
