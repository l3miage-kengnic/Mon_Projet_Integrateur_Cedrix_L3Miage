package fr.uga.l3miage.integrator.models;

import fr.uga.l3miage.integrator.DataType.Adresse;
import fr.uga.l3miage.integrator.DataType.GeoPosition;
import fr.uga.l3miage.integrator.enums.EtatsDeClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
    @Id
    private String email;
    private String prenom;
    private String nom;
    @Enumerated(EnumType.STRING)
    private EtatsDeClient etat;
    private double montantTotal;// a revoir
    private Adresse adresse;
    private GeoPosition position;
    @OneToMany(mappedBy = "clientEntity")
    private Collection<CommandeEntity> commandeEntities;
}
