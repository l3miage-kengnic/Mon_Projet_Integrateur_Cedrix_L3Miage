package fr.uga.l3miage.integrator.models;

import fr.uga.l3miage.integrator.DataType.GeoPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CamionEntity {
    @Id
    private String immatriculation;
    private GeoPosition position;
    @ManyToOne
    private EntrepotEntity entrepotEntity;
    @OneToMany(mappedBy = "camionEntity")
    private Set<TourneeEntity> tourneeEntities;
}
