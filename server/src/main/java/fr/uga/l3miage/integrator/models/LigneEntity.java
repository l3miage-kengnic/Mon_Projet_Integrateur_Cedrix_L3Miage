package fr.uga.l3miage.integrator.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneEntity {
    @Id
    private int quantite;
    private double montant;
    private boolean optionMontage;

    @ManyToOne
    private CommandeEntity commandeEntity;
    @ManyToOne
    private ProduitEntity produitEntity;
}
