package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.JourneeComponent;
import fr.uga.l3miage.integrator.mappers.JourneeMapper;
import fr.uga.l3miage.integrator.models.JourneeEntity;
import fr.uga.l3miage.integrator.repositories.JourneeRepository;
import fr.uga.l3miage.integrator.requests.JourneeCreationRequest;
import fr.uga.l3miage.integrator.requests.JourneeUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JourneeService {

    private final JourneeRepository journeeRepository;
    private final JourneeComponent journeeComponent;
    private final JourneeMapper journeeMapper;

    //"à revoir, car selon moi un DTO doit ètre renvoyé par le Service, et non un Entity": Cedrix
    public Optional<JourneeEntity> getJournee(String reference) {
        //return journeeRepository.findById(reference);
        return  journeeComponent.getJournee(reference);
    }

    public JourneeEntity createJournee(JourneeCreationRequest request) {
        /*** JourneeEntity journeeEntity = journeeMapper.createRequestToEntity(request);
        return journeeRepository.save(journeeEntity);  Normalement, c'est juste journeeComponent qui doit etre appelé
          et le traitement va continuer dans les couches inférieures ***/

        JourneeEntity journeeEntity = journeeComponent.createJournee( journeeMapper.createRequestToEntity(request));
        return journeeEntity;
    }

    public Optional<JourneeEntity> updateJournee(String reference, JourneeUpdateRequest request) {
        Optional<JourneeEntity> optionalJourneeEntity = journeeRepository.findById(reference);
        if (optionalJourneeEntity.isPresent()) {
            JourneeEntity updatedEntity = journeeMapper.updateEntityFromRequest(optionalJourneeEntity.get(), request);
            journeeRepository.save(updatedEntity);
        }
        return optionalJourneeEntity;
    }
}
