package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.exceptions.technical.NotFoundTourneeEntityException;
import fr.uga.l3miage.integrator.models.TourneeEntity;
import fr.uga.l3miage.integrator.repositories.TourneeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

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


}
