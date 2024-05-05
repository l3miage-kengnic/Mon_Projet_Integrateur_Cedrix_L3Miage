package fr.uga.l3miage.integrator.models;

import fr.uga.l3miage.integrator.enums.EtatsDeTournee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourneeEntity {
    @Id
    private String reference;
    @Enumerated(EnumType.STRING)
    private EtatsDeTournee etat;
    private String lettre;
    private double montant; //a revoir ou D
    private int tdmTheorique;
    private int tdmEffectif;
    private double distanceAParcourir;
    private double distanceDeRetour;


    @ManyToOne
    private JourneeEntity journeeEntity;

    @ManyToOne
    private CamionEntity camionEntity;

    @ManyToMany(mappedBy = "tourneeEntities",fetch= FetchType.LAZY)
    private Collection<EmployeEntity> employeEntities=new ArrayList<>();
    @OneToMany(mappedBy="tourneeEntity")
    private Set<LivraisonEntity> livraisonEntities;




}
