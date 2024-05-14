package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.models.JourneeEntity;
import fr.uga.l3miage.integrator.repositories.JourneeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JourneeComponent {

    private final JourneeRepository journeeRepository;

    public Optional<JourneeEntity> getJournee(String reference) {
        return journeeRepository.findById(reference);
    }

    public JourneeEntity createJournee(JourneeEntity journeeEntity) {
        return journeeRepository.save(journeeEntity);
    }

    public Optional<JourneeEntity> updateJournee(String reference, JourneeEntity updatedJournee) {
        Optional<JourneeEntity> optionalJournee = journeeRepository.findById(reference);
        optionalJournee.ifPresent(journee -> updatedJournee.setReference(journee.getReference()));
        return optionalJournee.map(journeeRepository::save);
    }
}