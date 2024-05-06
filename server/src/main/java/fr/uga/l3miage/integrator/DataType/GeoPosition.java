package fr.uga.l3miage.integrator.DataType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class GeoPosition {
    private double latitude;
    private double longitude;
}
