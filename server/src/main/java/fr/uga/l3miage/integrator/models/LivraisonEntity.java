package fr.uga.l3miage.integrator.models;

import fr.uga.l3miage.integrator.enums.EtatsDeLivraison;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivraisonEntity {
    @Id
    private String reference;
    @Enumerated(EnumType.STRING)
    private EtatsDeLivraison etat;
    private Float montant;
    private Float distanceAParcourir;
    private int tdtALAller;
    private int tdpTheorique;
    private int tddTheorique;
    private int tdmTheorique;
    @Temporal(TemporalType.TIME)
    private Date heureDeLivraisonTheorique;
    private Date heureDeLivraisonEffective;
    private int tdmEffectif;

    @ManyToOne
    private TourneeEntity tourneeEntity;
    //@OneToMany(mappedBy = "livraisonEntity")
    //private Set<CommandeEntity> commandeEntities;

    @OneToMany(mappedBy = "livraisonEntity", cascade = CascadeType.ALL)
    private List<CommandeEntity> commandes = new ArrayList<>();



    public List<CommandeEntity> getCommandeEntities() {
        return this.commandes;
    }


    public void addCommande(CommandeEntity commande) {
        this.commandes.add(commande);
        commande.setLivraisonEntity(this);
    }


    public String getReference() {
        return this.commandes.stream()
                .map(CommandeEntity::getReference)
                .collect(Collectors.joining(", "));
    }
}
