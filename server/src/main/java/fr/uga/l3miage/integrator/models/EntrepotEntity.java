package fr.uga.l3miage.integrator.models;

import fr.uga.l3miage.integrator.DataType.Adresse;
import fr.uga.l3miage.integrator.DataType.GeoPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Builder
public class EntrepotEntity {
    @Id
    //private String id;
    private String name;
    private String lettre;
    private String photo;
    @Embedded
    private Adresse adresse;
    @Embedded
    private GeoPosition position;
    @OneToMany(mappedBy = "entrepotEntity")
    private Set<JourneeEntity> journeeEntities;
    @OneToOne
    private EmployeEntity employeEntity;
    @OneToMany(mappedBy = "entrepotEntity")
    private Set<CamionEntity> camionEntities;
    @OneToMany(mappedBy = "entrepotEntity")
    private Set<StockEntity> stockEntities;

    //@OneToMany(mappedBy = "entrepotEntity") // Liens vers EmployeEntity.entrepotEntity
    //private Set<EmployeEntity> employeEntities;

}
