package fr.uga.l3miage.integrator.responses;

//import fr.uga.l3miage.integrator.DataType.Adresse;
//import fr.uga.l3miage.integrator.DataType.GeoPosition;
<<<<<<< HEAD
import fr.uga.l3miage.integrator.DataType.Adresse;
import fr.uga.l3miage.integrator.DataType.GeoPosition;
=======
>>>>>>> e10fd43872720309e2176afdd436d2f2188e1ee1
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "EntrepotResponseDTO", description = "Représentation d'un entrepôt")
public class EntrepotResponseDTO {
    @Schema(description = "Nom de l'entrepôt")
    private String name;

    @Schema(description = "Lettre unique associée à l'entrepôt")
    private String lettre;

    @Schema(description = "Photo de l'entrepôt")
    private String photo;

<<<<<<< HEAD
    @Schema(description = "Adresse de l'entrepôt")
    private Adresse adresse;

    @Schema(description = "Position géographique de l'entrepôt")
    private GeoPosition position;

    /*@Schema(description = "Employé responsable de l'entrepôt")
    private EmployeResponseDTO employe;

    @Schema(description = "Liste des camions associés à l'entrepôt")
    private List<CamionResponseDTO> camions;*/
    @Schema(description = "Trigramme de l'employé")
    private String employeEntityTrigramme;
}
//
=======
    /*@Schema(description = "Adresse de l'entrepôt")
    private Adresse adresse;

    @Schema(description = "Position géographique de l'entrepôt")
    private GeoPosition position;*/
}
>>>>>>> e10fd43872720309e2176afdd436d2f2188e1ee1
