package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.enums.EtatsDeTournee;
import fr.uga.l3miage.integrator.exceptions.technical.NotFoundTourneeEntityException;
import fr.uga.l3miage.integrator.models.LivraisonEntity;
import fr.uga.l3miage.integrator.models.TourneeEntity;
import fr.uga.l3miage.integrator.repositories.TourneeRepository;
import fr.uga.l3miage.integrator.requests.LivraisonCreationRequest;
import fr.uga.l3miage.integrator.requests.TourneeCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class TourneeComponent {
    private final TourneeRepository tourneeRepository;

    public TourneeEntity getTourneeEntityByReference(String reference) throws NotFoundTourneeEntityException {
        try {
            return tourneeRepository.findByReference(reference);
        }catch (Exception e){
            throw new NotFoundTourneeEntityException(String.format("la tournée %s n'a pas été trouvée", reference));
        }
    }

    public TourneeEntity creatTournee(TourneeCreationRequest tourneeCreationRequest){
        EtatsDeTournee e = EtatsDeTournee.valueOf((tourneeCreationRequest.getEtat()));
        Set<LivraisonEntity> livraisonEntities;

        for( LivraisonCreationRequest livraisonCreationRequest: tourneeCreationRequest.getLivraisons()){
            //pour chaque livraisonRequest de tourneeCreationRequest, creer une LivraisonEntity
              // LivraisonComponet livraisonComponent.CreatLivraison(livraisonCreationRequest )
              // et l'ajouter à livraisonEntities :  ....
        }

        TourneeEntity tourneeEntity = TourneeEntity
                .builder()
                .reference(tourneeCreationRequest.getReference())
                .lettre(tourneeCreationRequest.getLettre())
                .etat(e)
                .montant(tourneeCreationRequest.getMontant())
                .livraisonEntities(livraisonEntities)
                .build();


    }


}
