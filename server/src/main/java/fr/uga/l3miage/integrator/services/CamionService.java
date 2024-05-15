package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.CamionComponent;
import fr.uga.l3miage.integrator.exceptions.rest.NotFoundEntityRestException;
import fr.uga.l3miage.integrator.exceptions.technical.NotFoundCamionEntityException;
import fr.uga.l3miage.integrator.mappers.CamionMapper;
import fr.uga.l3miage.integrator.responses.CamionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CamionService {

    private final CamionComponent camionComponent;
    private final CamionMapper camionMapper;

    public List<CamionResponseDTO> getAllCamions() throws NotFoundEntityRestException {
        try {
            return camionComponent.getAllCamions()
                    .stream()
                    .map(camionMapper::entityToDto)
                    .collect(Collectors.toList());
        }catch (NotFoundCamionEntityException e){
            throw new NotFoundEntityRestException(e.getMessage());
        }

    }
}
