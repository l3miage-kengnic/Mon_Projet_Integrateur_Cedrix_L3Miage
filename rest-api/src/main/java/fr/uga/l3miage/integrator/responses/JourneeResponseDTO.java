package fr.uga.l3miage.integrator.responses;

import lombok.Data;

import java.util.Date;

@Data
public class JourneeResponseDTO {

    private String reference;

    private Date date;

    private double distanceAParcourir;

    private double montant;

    private int tdmTheorique;
}
