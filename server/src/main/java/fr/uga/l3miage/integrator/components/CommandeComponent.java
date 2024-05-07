package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.enums.EtatsDeCommande;
import fr.uga.l3miage.integrator.models.CommandeEntity;
import fr.uga.l3miage.integrator.models.Enums.EtatDeCommande;
import fr.uga.l3miage.integrator.repositories.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class CommandeComponent {
    private  final CommandeRepository commandeRepository;

    // renvoie un ensemble de CommandeEntity
    public Set<CommandeEntity> getAllCommandes(){
        return commandeRepository.getAllByEtat(EtatsDeCommande.PLANIFIEE); // renvoyer toutes les commandes planifiées
    }
}
