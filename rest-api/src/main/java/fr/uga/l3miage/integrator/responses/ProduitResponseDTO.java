package fr.uga.l3miage.integrator.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(description = "description de produit renvoyé")
@Data
public class ProduitResponseDTO {
    @Schema(description = "reference de la commande")
    private String reference;

    @Schema(description = "titre du produit")
    private String titre;
}
