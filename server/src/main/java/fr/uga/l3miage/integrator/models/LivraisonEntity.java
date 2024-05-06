package fr.uga.l3miage.integrator.models;

import fr.uga.l3miage.integrator.enums.EtatsDeLivraison;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivraisonEntity {
    @Id
    private String reference;
    @Enumerated(EnumType.STRING)
    private EtatsDeLivraison etat;
    private Float montant;

    /*****    Cedrix est passé par ici: ceci n'est pas util pour le moment
    private Float distanceAParcourir;
    private int tdtALAller;
    private int tdpTheorique;
    private int tddTheorique;
    private int tdmTheorique;
    @Temporal(TemporalType.TIME)
    private Date heureDeLivraisonTheorique;
    private Date heureDeLivraisonEffective;
    private int tdmEffectif;
      ****/
    /*@ManyToOne
    private TourneeEntity tourneeEntity;  Cedrix est passé par ici : pour le moment considérons qu'on a pas besoin de passer par une livraison pour accéder à sa tournée **/
     //mais plustot on accède à la tourner directement


    @OneToMany(mappedBy = "livraisonEntity")
    private Set<CommandeEntity> commandeEntities;
}
