package fr.uga.l3miage.integrator.models;

import fr.uga.l3miage.integrator.enums.Emploi;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table
public class EmployeEntity {
    @Id
    private String trigramme;
    private String email;
    private String prenom;
    private String nom;
    private String photo;
    private String telephone;
    @Enumerated(EnumType.STRING)
    private Emploi emploi;

    @ManyToMany
    private Collection<TourneeEntity> tourneeEntities=new ArrayList<>();
    @OneToOne
    private EntrepotEntity entrepotEntity;
}
