package fr.uga.l3miage.integrator.requests;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class JourneeCreationRequest {

    @NotNull
    final private String reference;

    @NotNull
    final  private Date date;

    @NotNull
    final private double distanceAParcourir;

    @NotNull
    final private double montant;

    @NotNull
    final private int tdmTheorique;
}
