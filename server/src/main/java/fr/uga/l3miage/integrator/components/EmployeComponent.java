package fr.uga.l3miage.integrator.components;

import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.models.EmployeEntity;
import fr.uga.l3miage.integrator.repositories.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Set;

// Annotation pour indiquer que cette classe est un composant Spring
@Component
@RequiredArgsConstructor
public class EmployeComponent {
    // Dépendance pour le référentiel Employe
    private final EmployeRepository employeRepository;


    // Méthode pour récupérer tous les employés
    public List<EmployeEntity> getAllEmployes() {
        return employeRepository.findAll();// Récupère tous les enregistrements d'employés dans la base de données
    }
    //public Set<EmployeEntity> finAllLivreurs() {

      //  return employeRepository.findAllByEmploi(Emploi.livreur);
    //}


    // Méthode pour récupérer les employés par rôle
    public Set<EmployeEntity> findByEmploi(Emploi emploi) {
        return employeRepository.findAllByEmploi(emploi);// Récupère les employés ayant le rôle donné
    }

    public EmployeEntity  creatEmploye(EmployeEntity employeEntity){
        return employeRepository.save(employeEntity);
    }

}