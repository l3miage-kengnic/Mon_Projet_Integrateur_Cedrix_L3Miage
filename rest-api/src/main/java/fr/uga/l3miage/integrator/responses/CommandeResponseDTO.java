package fr.uga.l3miage.integrator.responses;

import fr.uga.l3miage.integrator.enums.EtatsDeCommande;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import java.util.Date;

@Data
@Schema(name = "CommandeResponseDTO", description = "Commande response")
public class CommandeResponseDTO {
    private String reference;
    private EtatsDeCommande etat;
    private Date dateDeCommande;
    private double montant;
}
