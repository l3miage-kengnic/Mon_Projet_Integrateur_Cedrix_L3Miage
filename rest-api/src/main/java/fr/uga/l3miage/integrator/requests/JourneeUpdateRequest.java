package fr.uga.l3miage.integrator.requests;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class JourneeUpdateRequest {

    private Date date;

    private Double distanceAParcourir;

    private Double montant;

    private Integer tdmTheorique;
}
