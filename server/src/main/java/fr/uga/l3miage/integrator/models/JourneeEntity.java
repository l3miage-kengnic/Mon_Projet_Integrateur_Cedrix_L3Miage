package fr.uga.l3miage.integrator.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JourneeEntity {
    @Id
    private String reference;
    private Date date;
    private double distanceAParcourir;
    private double montant; //a revoir
    private int tdmTheorique;

    @OneToMany(mappedBy = "journeeEntity")// fetch = FetchType.LAZY qui est par defaut
    private Set<TourneeEntity> tourneeEntities;
    @ManyToOne
    private EntrepotEntity entrepotEntity;
}
