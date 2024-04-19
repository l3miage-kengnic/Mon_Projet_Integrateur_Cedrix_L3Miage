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
public class StockEntity {
    @Id
    private int quantite;
    @ManyToOne
    private ProduitEntity produitEntity;
    @ManyToOne
    private EntrepotEntity entrepotEntity;
}
