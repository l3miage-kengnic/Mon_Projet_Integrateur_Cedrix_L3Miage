package fr.uga.l3miage.integrator.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogueEntity {
    @Id
    private String reference;
    private String name;
    private String description;
    @OneToMany(mappedBy = "catalogueEntity")
    private Set<ProduitEntity> produitEntities;
}
