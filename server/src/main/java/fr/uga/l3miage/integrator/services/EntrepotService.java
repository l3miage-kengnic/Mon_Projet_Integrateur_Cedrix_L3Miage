/*package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.EntrepotComponent;
import fr.uga.l3miage.integrator.responses.EntrepotResponseDTO;
import fr.uga.l3miage.integrator.models.EntrepotEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EntrepotService {
    // Dépendance pour le composant Entrepot
    private final EntrepotComponent entrepotComponent;

    // Méthode pour récupérer tous les entrepôts
    public List<EntrepotResponseDTO> getAllEntrepots() {
        return entrepotComponent.getAllEntrepots()  // Obtenir tous les entrepôts via le composant
                .stream()  // Utiliser un flux de données
                .map(this::convertToDTO)  // Convertir en DTO
                .collect(Collectors.toList());  // Retourner sous forme de liste
    }

    // Méthode pour récupérer un entrepôt par son identifiant
    public EntrepotResponseDTO getEntrepotById(String id) {
        EntrepotEntity entrepot = entrepotComponent.findById(id);  // Chercher l'entrepôt par ID
        if (entrepot == null) {
            return null;  // Retourner null si l'entrepôt n'est pas trouvé
        }
        return convertToDTO(entrepot);  // Convertir l'entrepôt trouvé en DTO
    }

    // Méthode pour créer un nouvel entrepôt
    public EntrepotResponseDTO createEntrepot(EntrepotResponseDTO entrepotDTO) {
        EntrepotEntity newEntrepot = convertToEntity(entrepotDTO);  // Convertir le DTO en entité
        newEntrepot.setId(UUID.randomUUID().toString());  // Générer un ID unique
        entrepotComponent.save(newEntrepot);  // Sauvegarder le nouvel entrepôt
        return convertToDTO(newEntrepot);  // Retourner le DTO de l'entrepôt créé
    }

    // Méthode pour mettre à jour un entrepôt
    public EntrepotResponseDTO updateEntrepot(String id, EntrepotResponseDTO entrepotDTO) {
        EntrepotEntity existingEntrepot = entrepotComponent.findById(id);  // Chercher l'entrepôt par ID
        if (existingEntrepot == null) {
            return null;  // Si l'entrepôt n'est pas trouvé, retourner null
        }
        // Mettre à jour les attributs de l'entrepôt existant
        existingEntrepot.setLettre(entrepotDTO.getLettre());
        existingEntrepot.setPhoto(entrepotDTO.getPhoto());
        //existingEntrepot.setAdresse(entrepotDTO.getAdresse());
       // existingEntrepot.setGeoPosition(entrepotDTO.getGeoPosition());
        // Enregistrer les modifications
        entrepotComponent.save(existingEntrepot);
        return convertToDTO(existingEntrepot);  // Retourner le DTO de l'entrepôt mis à jour
    }

    // Méthode pour supprimer un entrepôt
    public boolean deleteEntrepot(String id) {
        EntrepotEntity existingEntrepot = entrepotComponent.findById(id);  // Chercher l'entrepôt par ID
        if (existingEntrepot == null) {
            return false;  // Si l'entrepôt n'est pas trouvé, retourner false
        }
        entrepotComponent.delete(existingEntrepot);  // Supprimer l'entrepôt
        return true;  // Indiquer que la suppression a réussi
    }

    // Méthode pour convertir une entité Entrepot en DTO
    private EntrepotResponseDTO convertToDTO(EntrepotEntity entrepot) {
        return EntrepotResponseDTO.builder()  // Utilisation du Builder
                .id(entrepot.getId())
                .lettre(entrepot.getLettre())
                .photo(entrepot.getPhoto())
                .adresse(entrepot.getAdresse())
                .geoPosition(entrepot.getGeoPosition())
                .build();  // Retourner le DTO construit
    }

    // Méthode pour convertir un DTO en entité Entrepot
    private EntrepotEntity convertToEntity(EntrepotResponseDTO entrepotDTO) {
        return EntrepotEntity.builder()  // Utilisation du Builder
                .lettre(entrepotDTO.getLettre())
                .photo(entrepotDTO.getPhoto())
                .adresse(entrepotDTO.getAdresse())
                .geoPosition(entrepotDTO.getGeoPosition())
                .build();  // Retourner l'entité construite
    }
}*/
