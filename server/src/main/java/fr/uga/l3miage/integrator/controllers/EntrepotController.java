package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.endpoints.EntrepotEndpoint;
import fr.uga.l3miage.integrator.responses.EntrepotResponseDTO;
import fr.uga.l3miage.integrator.services.EntrepotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
=======
>>>>>>> e10fd43872720309e2176afdd436d2f2188e1ee1
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
<<<<<<< HEAD
@CrossOrigin("http://localhost:4200")
=======
>>>>>>> e10fd43872720309e2176afdd436d2f2188e1ee1
public class EntrepotController implements EntrepotEndpoint {

    private final EntrepotService entrepotService;

<<<<<<< HEAD
    /*@Override
    public ResponseEntity<List<EntrepotResponseDTO>> getAllEntrepots() {
        List<EntrepotResponseDTO> responseDTOs = entrepotService.getAllEntrepots();
        return ResponseEntity.ok(responseDTOs);
    }*/
    @Override
    public ResponseEntity<List<EntrepotResponseDTO>> getAllEntrepots() {
        List<EntrepotResponseDTO> responseDTOs = entrepotService.getAllEntrepots(); // Utilisation du service mis à jour
        return ResponseEntity.ok(responseDTOs);
=======
    @Override
    public ResponseEntity<List<EntrepotResponseDTO>> getAllEntrepots() {
        List<EntrepotResponseDTO> responseDTOs = entrepotService.getAllEntrepots();
        return ResponseEntity.ok(responseDTOs);
>>>>>>> e10fd43872720309e2176afdd436d2f2188e1ee1
    }
}
