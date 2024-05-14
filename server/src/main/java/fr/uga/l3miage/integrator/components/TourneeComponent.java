package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.models.TourneeEntity;
import fr.uga.l3miage.integrator.repositories.TourneeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TourneeComponent {
    private final TourneeRepository tourneeRepository;

    public List<TourneeEntity> getAllTournees() {
        return tourneeRepository.findAll();
    }

    public TourneeEntity getTourneeByReference(String refTournee) {
        return tourneeRepository.findById(refTournee).orElse(null);
    }

    public TourneeEntity createTournee(TourneeEntity tourneeEntity) {
        return tourneeRepository.save(tourneeEntity);
    }

    public TourneeEntity updateTournee(String refTournee, TourneeEntity updatedTournee) {
        return tourneeRepository.save(updatedTournee);
    }
    public void deleteTournee(TourneeEntity tournee) {
        tourneeRepository.delete(tournee); // Supprime la tournée de la base de données
    }
}
