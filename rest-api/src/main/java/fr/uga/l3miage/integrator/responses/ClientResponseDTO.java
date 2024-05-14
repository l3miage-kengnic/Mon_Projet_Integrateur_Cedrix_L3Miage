package fr.uga.l3miage.integrator.responses;

import fr.uga.l3miage.integrator.DataType.Adresse;
import fr.uga.l3miage.integrator.DataType.GeoPosition;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "ClientResponseDTO", description = "Client response")

public class ClientResponseDTO {
    private String email;
    private String prenom;
    private String nom;
    private Adresse adresse;
    private GeoPosition position;
}
