package fr.uga.l3miage.integrator.requests;

import lombok.Data;

import java.util.Date;

@Data
public class TourneeUpdateRequest {
        private final Date date;

        private final Double distanceAParcourir;

        private final Double montant;

        private final Integer tdmTheorique;

        private final String nom;
        private final String description;

}


