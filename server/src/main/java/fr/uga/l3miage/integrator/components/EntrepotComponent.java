package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.models.EntrepotEntity;
import fr.uga.l3miage.integrator.repositories.EntrepotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EntrepotComponent {

    private final EntrepotRepository entrepotRepository;

    public List<EntrepotEntity> getAllEntrepots() {
        return entrepotRepository.findAll();
    }
}
