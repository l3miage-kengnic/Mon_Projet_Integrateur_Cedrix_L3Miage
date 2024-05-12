package fr.uga.l3miage.integrator.DataType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adresse {
    private String adresse;
    private String codePostal;
    private String ville;
<<<<<<< HEAD
}
=======

    @Override
    public String toString() {
        return "Adresse{" +
                "adresse='" + adresse + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
>>>>>>> e10fd43872720309e2176afdd436d2f2188e1ee1
