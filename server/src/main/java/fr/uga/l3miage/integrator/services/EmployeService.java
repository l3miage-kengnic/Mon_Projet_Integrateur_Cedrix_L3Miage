package fr.uga.l3miage.integrator.services;
import fr.uga.l3miage.integrator.exceptions.rest.NotFoundEntityRestException;
import fr.uga.l3miage.integrator.exceptions.technical.NotFoundEmployeEntityException;
import fr.uga.l3miage.integrator.mappers.EmployeMapper;


import java.util.stream.Collectors;

/*package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.EmployeComponent;
import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.responses.EmployeResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// Annotation qui indique que cette classe est un service Spring
@Service
@RequiredArgsConstructor
public class EmployeService {
    // Dépendance pour le composant Employe, qui interagit avec la base de données ou d'autres sources de données
    private final EmployeComponent employeComponent;


    // Méthode pour récupérer tous les employés
    public List<EmployeResponseDTO> getAllEmployes() {
        // Récupère tous les employés via le composant Employe
        // Utilisation de Java Stream pour convertir les entités Employe en EmployeResponseDTO
        return employeComponent.getAllEmployes()          // Obtenir la liste des EmployeEntity
                .stream()   // Créer un flux de données
                .map(this::convertToDTO)    // Appliquer une transformation pour chaque élément du flux
                .collect(Collectors.toList());  // Convertir le flux en liste
    }

    // Méthode pour récupérer les employés par rôle (emploi)
    public Set<EmployeResponseDTO> getEmployesByEmploi(Emploi emploi) {
        // Récupère les employés avec le rôle spécifié
        return employeComponent.findByEmploi(emploi)// Obtenir les employés avec le rôle donné
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toSet());
    }

    // Méthode pour convertir une entité Employe en EmployeResponseDTO
    public EmployeResponseDTO convertToDTO(EmployeEntity employeEntity) {
        // Crée un objet DTO et y transfère les données de l'entité Employe
        EmployeResponseDTO dto = new EmployeResponseDTO();
        dto.setTrigramme(employeEntity.getTrigramme());
        dto.setEmail(employeEntity.getEmail());
        dto.setPrenom(employeEntity.getPrenom());
        dto.setNom(employeEntity.getNom());
        dto.setTelephone(employeEntity.getTelephone());
        dto.setPhoto(employeEntity.getPhoto());
        dto.setEmploi(employeEntity.getEmploi());
        return dto;// Retourne le DTO avec les données converties
    }
}




package fr.uga.l3miage.integrator.services;

import fr.uga.l3miage.integrator.components.EmployeComponent;
import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.mappers.EmployeMapper;
import fr.uga.l3miage.integrator.responses.EmployeResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

    @Service
    @RequiredArgsConstructor
    public class EmployeService {

        private final EmployeComponent employeComponent;
        private final EmployeMapper employeMapper; // Injecter le mapper

        public List<EmployeResponseDTO> getAllEmployes() {
            return employeComponent.getAllEmployes()
                    .stream()
                    .map(employeMapper::entityToDto) // Utiliser le mapper pour la conversion
                    .collect(Collectors.toList());
        }

        public Set<EmployeResponseDTO> getEmployesByEmploi(Emploi emploi) {
            return employeComponent.findByEmploi(emploi)
                    .stream()
                    .map(employeMapper::entityToDto) // Utiliser le mapper pour la conversion
                    .collect(Collectors.toSet());
        }
    }
*/
import fr.uga.l3miage.integrator.components.EmployeComponent;
import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.mappers.EmployeMapper;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.requests.EmployeCreationRequest;
import fr.uga.l3miage.integrator.responses.EmployeResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeService {

    private final EmployeComponent employeComponent;
    private final EmployeMapper employeMapper;

    public List<EmployeResponseDTO> getAllEmployes() {
        try {
            return employeComponent.getAllEmployes()
                    .stream()
                    .map(employeMapper::entityToDto)
                    .collect(Collectors.toList());
        } catch (NotFoundEmployeEntityException e){
            throw new NotFoundEntityRestException(e.getMessage());
        }
    }

    public Set<EmployeResponseDTO> getEmployesByEmploi(Emploi emploi) {
        try {
            return employeComponent.findByEmploi(emploi)
                    .stream()
                    .map(employeMapper::entityToDto)
                    .collect(Collectors.toSet());
        } catch (NotFoundEmployeEntityException e){
            throw new NotFoundEntityRestException(e.getMessage());
        }

        /*******Set<EmployeResponseDTO> employeResponseDTOSet = Set.of();
         Set<EmployeEntity> employeEntities = employeComponent.findByEmploi(emploi);
         for( EmployeEntity employeEntity: employeEntities){
         employeResponseDTOSet.add(employeMapper.entityToDto(employeEntity));
         }
         return employeResponseDTOSet;**********/
    }


    public EmployeResponseDTO creatEmploye(EmployeCreationRequest employeCreationRequest){
        EmployeEntity employeEntity = employeMapper.requestToEntity(employeCreationRequest);
        employeEntity.setTourneeEntities(
                employeCreationRequest.getTournees().stream().map(employeMapper::stringToEntiy).collect(Collectors.toSet())
        );
        employeComponent.creatEmploye(employeEntity);
        return employeMapper.entityToDto(employeEntity);
    }
}
