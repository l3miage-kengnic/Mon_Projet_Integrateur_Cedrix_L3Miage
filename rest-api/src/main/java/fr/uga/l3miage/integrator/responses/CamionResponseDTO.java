package fr.uga.l3miage.integrator.responses;

import fr.uga.l3miage.integrator.DataType.GeoPosition;
import lombok.Data;

@Data
public class CamionResponseDTO {
    private String immatriculation;
    private GeoPosition position;

}
