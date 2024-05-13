package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.endpoints.CamionEndpoint;
import fr.uga.l3miage.integrator.responses.CamionResponseDTO;
import fr.uga.l3miage.integrator.services.CamionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CamionController implements CamionEndpoint {

    private final CamionService camionService;

    @Override
    public ResponseEntity<List<CamionResponseDTO>> getAllCamions() {
        List<CamionResponseDTO> responseDTOs = camionService.getAllCamions();
        return ResponseEntity.ok(responseDTOs);
    }
}
