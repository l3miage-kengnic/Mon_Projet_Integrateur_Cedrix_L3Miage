package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.exceptions.technical.NotFoundJourneeEntityException;
import fr.uga.l3miage.integrator.models.JourneeEntity;
import fr.uga.l3miage.integrator.repositories.JourneeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JourneeComponent {

    @Autowired
    private final JourneeRepository journeeRepository;

    public Optional<JourneeEntity> getJournee(String reference) throws NotFoundJourneeEntityException {
        try {
            return journeeRepository.findById(reference);
        }catch (Exception e){
            throw new NotFoundJourneeEntityException("Aucune journée trouvée");
        }
    }

    public JourneeEntity createJournee(JourneeEntity journeeEntity) {
        return journeeRepository.save(journeeEntity);
    }

    public Optional<JourneeEntity> updateJournee(String reference, JourneeEntity updatedJournee) throws NotFoundJourneeEntityException{
            Optional<JourneeEntity> optionalJournee = Optional.of(journeeRepository.findById(reference).orElseThrow(()->new NotFoundJourneeEntityException("Aucune journée trouvée avec une telle reference trouvée")));
            optionalJournee.ifPresent(journee -> updatedJournee.setReference(journee.getReference()));
            return Optional.of(journeeRepository.save(updatedJournee));
    }
}