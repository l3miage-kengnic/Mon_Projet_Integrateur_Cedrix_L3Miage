package fr.uga.l3miage.integrator.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Schema
public class LigneResponseDTO {
    private boolean optionMontage;

    private ProduitResponseDTO produitResponseDTO;
}
