package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.LivraisonComponent;
import fr.uga.l3miage.integrator.enums.EtatsDeLivraison;
import fr.uga.l3miage.integrator.mappers.LivraisonMapper;
import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.models.LivraisonEntity;
import fr.uga.l3miage.integrator.responses.LivraisonResponseDTO;
import fr.uga.l3miage.integrator.responses.CommandeResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivraisonService {

    private final LivraisonComponent livraisonComponent;
    private final LivraisonMapper livraisonMapper;

    public List<LivraisonResponseDTO> getAllLivraisons() {
        return livraisonComponent.getAllLivraisons()
                .stream()
                .map(livraisonMapper::entityToDto)
                .collect(Collectors.toList());

    }


    /*public List<CommandeResponseDTO> getCommandesByLivraison(String reference) {
        return livraisonComponent.getAllLivraisons()
                .stream()
                .filter(l -> l.getReference().equals(reference))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Livraison not found"))
                .getCommandeEntities()
                .stream()
                .map(livraisonMapper::commandeEntityToCommandeResponseDTO)
                .collect(Collectors.toList());
    }*/
    private List<LivraisonEntity> createLivraisonsFromCommande(CommandeEntity commande) {
        List<LivraisonEntity> livraisons = new ArrayList<>();

        // Generate a random number between 1 and 19
        int numberOfLivraisons = new Random().nextInt(19) + 1;

        for (int i = 0; i < numberOfLivraisons; i++) {
            LivraisonEntity livraison = new LivraisonEntity();
            livraison.setReference(commande.getReference());
            livraison.setMontant(100.0f); // Set random or default values
            livraison.setEtat(EtatsDeLivraison.PLANIFIEE); // Set the state of the delivery
            livraison.getCommandes().add(commande); // Add the CommandeEntity to the list of commandes
            livraisons.add(livraison);
        }

        return livraisons;
    }

    public List<CommandeResponseDTO> getCommandesByLivraison(String reference) {
        return livraisonComponent.getAllLivraisons()
                .stream()
                .filter(l -> l.getReference().equals(reference))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Livraison not found"))
                .getCommandeEntities()
                .stream()
                .map(livraisonMapper::commandeEntityToCommandeResponseDTO)
                .collect(Collectors.toList());
    }
}




