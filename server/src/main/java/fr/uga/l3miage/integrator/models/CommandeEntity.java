package fr.uga.l3miage.integrator.models;

import fr.uga.l3miage.integrator.enums.EtatsDeCommande;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandeEntity {
    @Id
    private String reference;
    //@Enumerated(EnumType.STRING)
    private EtatsDeCommande etat;
    private Date dateDeCommande;
    private int date;
    private String commentaire;
    private double montant;
    private int tddTheorique;
    private int tdmTheorique;
    private Date dateDeLivraisonEffective;
    private int dureeDeLivraison;

    @ManyToOne
    @JoinColumn(name = "livraison_id")
    private LivraisonEntity livraisonEntity;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;



    /*public void setLivraisonEntity(LivraisonEntity livraisonEntity) {
        this.livraisonEntity = livraisonEntity;
    }*/
}
