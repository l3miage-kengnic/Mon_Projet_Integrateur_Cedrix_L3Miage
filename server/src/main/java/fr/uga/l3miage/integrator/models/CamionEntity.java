package fr.uga.l3miage.integrator.models;

import fr.uga.l3miage.integrator.DataType.GeoPosition;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder  // Builder ajouté ici
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
