package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.EntrepotComponent;
import fr.uga.l3miage.integrator.mappers.EntrepotMapper;
import fr.uga.l3miage.integrator.responses.EntrepotResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EntrepotService {

    private final EntrepotComponent entrepotComponent;
    private final EntrepotMapper entrepotMapper;


    /*public List<EntrepotResponseDTO> getAllEntrepots() {
        return entrepotComponent.getAllEntrepots()
                .stream()
                .map(entrepotMapper::entityToDto)
                .collect(Collectors.toList());
    }*/


    public List<EntrepotResponseDTO> getAllEntrepots() {
        return entrepotComponent.getAllEntrepots()
                .stream()
                .map(entrepotMapper::entityToDto) // Le mapper inclut maintenant l'employé
                .collect(Collectors.toList());


        /**
        public List<EntrepotResponseDTO> getAllEntrepots () {
            return entrepotComponent.getAllEntrepots()
                    .stream()
                    .map(entrepotMapper::entityToDto)
                    .collect(Collectors.toList());   **/

    }
}
