package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.endpoints.JourneeEndpoint;
import fr.uga.l3miage.integrator.mappers.JourneeMapper;
import fr.uga.l3miage.integrator.models.JourneeEntity;
import fr.uga.l3miage.integrator.responses.JourneeResponseDTO;
import fr.uga.l3miage.integrator.requests.JourneeCreationRequest;
import fr.uga.l3miage.integrator.requests.JourneeUpdateRequest;
import fr.uga.l3miage.integrator.services.JourneeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
//@CrossOrigin("http://localhost:4200")
public class JourneeController implements JourneeEndpoint {

    private final JourneeService journeeService;
    private final JourneeMapper journeeMapper;

    @Override
    public ResponseEntity<JourneeResponseDTO> getJourneeByReference(String reference) {
        Optional<JourneeEntity> journeeEntity = journeeService.getJournee(reference);
        if (journeeEntity.isPresent()) {
            JourneeResponseDTO journee = journeeMapper.entityToDto(journeeEntity.get());
            return ResponseEntity.ok(journee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public void createJournee(JourneeCreationRequest creationRequest) {
        journeeService.createJournee(creationRequest);
        //return ResponseEntity.status(201).build(); ne doit pas toujours retourner ça
    }

    @Override
    public ResponseEntity<Void> updateJournee(String reference, JourneeUpdateRequest updateRequest) {
        journeeService.updateJournee(reference, updateRequest);
        return ResponseEntity.ok().build();
    }
}
