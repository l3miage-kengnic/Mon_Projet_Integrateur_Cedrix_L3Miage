package fr.uga.l3miage.integrator.responses;

import fr.uga.l3miage.integrator.DataType.GeoPosition;
import lombok.Builder;
import lombok.Data;

@Data
@Builder // Builder ajouté
public class CamionResponseDTO {
    private String immatriculation;
    private GeoPosition position;
    private String entrepot; // Nouvelle propriété pour le nom de l'entrepôt


}
