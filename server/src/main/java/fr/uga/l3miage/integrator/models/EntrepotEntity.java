package fr.uga.l3miage.integrator.models;

import fr.uga.l3miage.integrator.DataType.Adresse;
import fr.uga.l3miage.integrator.DataType.GeoPosition;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Builder
@Getter
@Setter
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



}
