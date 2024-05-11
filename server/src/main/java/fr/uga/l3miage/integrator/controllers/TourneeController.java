package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.endpoints.TourneeEndpoint;
import fr.uga.l3miage.integrator.mappers.TourneeMapper;
import fr.uga.l3miage.integrator.responses.TourneeResponseDTO;
import fr.uga.l3miage.integrator.requests.TourneeCreationRequest;
import fr.uga.l3miage.integrator.requests.TourneeUpdateRequest;
import fr.uga.l3miage.integrator.services.TourneeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tournees")
public class TourneeController implements TourneeEndpoint {

    private final TourneeService tourneeService;
    private final TourneeMapper tourneeMapper;

    @Override
    public ResponseEntity<TourneeResponseDTO> getTournee(String refTournee) {
        TourneeResponseDTO tournee = tourneeService.getTournee(refTournee);
        return ResponseEntity.ok(tournee);
    }

    @Override
    public ResponseEntity<Void> createTournee(TourneeCreationRequest request) {
        tourneeService.createTournee(request);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<Void> updateTournee(String refTournee, TourneeUpdateRequest request) {
        tourneeService.updateTournee(refTournee, request);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteTournee(String refTournee) {
        boolean deleted = tourneeService.deleteTournee(refTournee);
        if (deleted) {
            return ResponseEntity.noContent().build(); // Code 204 pour succès sans contenu
        } else {
            return ResponseEntity.notFound().build(); // Code 404 si la tournée n'existe pas
        }
    }
}
