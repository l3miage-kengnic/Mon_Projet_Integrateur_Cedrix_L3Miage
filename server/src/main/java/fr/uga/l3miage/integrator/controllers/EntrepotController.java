package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.endpoints.EntrepotEndpoint;
import fr.uga.l3miage.integrator.responses.EntrepotResponseDTO;
import fr.uga.l3miage.integrator.services.EntrepotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;


import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")

public class EntrepotController implements EntrepotEndpoint {

    private final EntrepotService entrepotService;

    /*@Override
    public ResponseEntity<List<EntrepotResponseDTO>> getAllEntrepots() {
        List<EntrepotResponseDTO> responseDTOs = entrepotService.getAllEntrepots();
        return ResponseEntity.ok(responseDTOs);
    }*/
    @Override
    public ResponseEntity<List<EntrepotResponseDTO>> getAllEntrepots() {
        List<EntrepotResponseDTO> responseDTOs = entrepotService.getAllEntrepots(); // Utilisation du service mis à jour
        return ResponseEntity.ok(responseDTOs);


        /** @Override
        public ResponseEntity<List<EntrepotResponseDTO>> getAllEntrepots () {
            List<EntrepotResponseDTO> responseDTOs = entrepotService.getAllEntrepots();
            return ResponseEntity.ok(responseDTOs);
        }  ***/

    }
}
