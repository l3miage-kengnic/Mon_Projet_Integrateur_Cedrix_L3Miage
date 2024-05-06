package fr.uga.l3miage.integrator.DataType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adresse {
    private String adresse;
    private String codePostal;
    private String ville;
}
