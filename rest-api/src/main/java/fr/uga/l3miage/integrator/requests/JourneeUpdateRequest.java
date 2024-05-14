package fr.uga.l3miage.integrator.requests;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder //Builder ajouté
public class JourneeUpdateRequest {

    private Date date;

    private Double distanceAParcourir;

    private Double montant;

    private Integer tdmTheorique;
}
