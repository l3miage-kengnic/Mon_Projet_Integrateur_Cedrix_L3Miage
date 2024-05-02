package fr.uga.l3miage.integrator.models;

import fr.uga.l3miage.integrator.DataType.Adresse;
import fr.uga.l3miage.integrator.DataType.GeoPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class EntrepotEntity {
    @Id //@GeneratedValue(strategy = GenerationType.IDENTITY)  //ca me donne erreur problème avec la création d'un bean
    //private String id;
    private String name;
    private String lettre;
    private String photo;
    private Adresse adresse;
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
