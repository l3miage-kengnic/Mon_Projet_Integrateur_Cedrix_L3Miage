package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.endpoints.CommandeEndpoint;
import fr.uga.l3miage.integrator.mappers.CommandeMapper;
import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import fr.uga.l3miage.integrator.requests.CommandeUpdateRequest;
import fr.uga.l3miage.integrator.services.CommandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class CommandeController implements CommandeEndpoint {
    private final CommandeService commandeService;
    private final CommandeMapper commandeMapper;

    @Override
    public ResponseEntity<List<CommandeResponseDTO>> getAllCommandes() {
        List<CommandeResponseDTO> commandes = commandeService.getAllCommandes();
        return ResponseEntity.ok(commandes);
    }

    @Override
    public ResponseEntity<CommandeResponseDTO> getCommandeByReference(String reference) {
        CommandeResponseDTO commande = commandeService.getCommandeByReference(reference);
        return ResponseEntity.ok(commande);
    }

    @Override
    public ResponseEntity<CommandeResponseDTO> updateCommande(String reference, CommandeUpdateRequest updateRequest) {
        CommandeResponseDTO updatedCommande = commandeService.updateCommande(reference, updateRequest);
        return ResponseEntity.ok(updatedCommande);
    }
}
