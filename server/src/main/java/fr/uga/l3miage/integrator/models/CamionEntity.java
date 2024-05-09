package fr.uga.l3miage.integrator.models;

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
public class CamionEntity {
    @Id
    private String immatriculation;
    @Embedded
    private GeoPosition position;
    @ManyToOne
    private EntrepotEntity entrepotEntity;
    @OneToMany(mappedBy = "camionEntity")
    private Set<TourneeEntity> tourneeEntities;
}
