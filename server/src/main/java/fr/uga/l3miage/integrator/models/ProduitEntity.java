package fr.uga.l3miage.integrator.models;

import fr.uga.l3miage.integrator.enums.Encombrement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitEntity {
    @Id
    private String reference;
    //private Image photo;
    private String photo;
    private String titre;
    private String description;
    private double prix;
    private boolean optionMontage;
    private int tdmTheorique;
    @Enumerated(EnumType.STRING)
    private Encombrement Encombrant;

    @ManyToOne
    private CatalogueEntity catalogueEntity;
    @OneToMany(mappedBy = "produitEntity")
    private Set<StockEntity> stockEntities;
    @OneToMany(mappedBy = "produitEntity")
    private Set<LigneEntity> ligneEntities;
}
