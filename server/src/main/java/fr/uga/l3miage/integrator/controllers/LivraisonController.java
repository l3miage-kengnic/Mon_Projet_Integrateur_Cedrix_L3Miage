package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.endpoints.LivraisonEndpoint;
import fr.uga.l3miage.integrator.responses.LivraisonResponseDTO;
import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import fr.uga.l3miage.integrator.services.LivraisonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LivraisonController implements LivraisonEndpoint {

    private final LivraisonService livraisonService;

    @Override
    public ResponseEntity<List<LivraisonResponseDTO>> getAllLivraisons() {
        List<LivraisonResponseDTO> livraisons = livraisonService.getAllLivraisons();
        return ResponseEntity.ok(livraisons);
    }

    @Override
    public ResponseEntity<List<CommandeResponseDTO>> getCommandesByLivraison(String reference) {
        List<CommandeResponseDTO> commandes = livraisonService.getCommandesByLivraison(reference);
        return ResponseEntity.ok(commandes);
    }
}
