package fr.uga.l3miage.integrator.requests;

import lombok.Data;

import java.util.Date;

@Data
public class TourneeUpdateRequest {
        private Date date;

        private Double distanceAParcourir;

        private Double montant;

        private Integer tdmTheorique;
}

