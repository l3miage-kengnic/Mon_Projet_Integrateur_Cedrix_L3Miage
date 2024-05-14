package fr.uga.l3miage.integrator.controllers;

import fr.uga.l3miage.integrator.endpoints.EmployeEndPoints;
import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.requests.EmployeCreationRequest;
import fr.uga.l3miage.integrator.responses.EmployeResponseDTO;
import fr.uga.l3miage.integrator.services.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

/*
import fr.uga.l3miage.integrator.components.EmployeComponent;
import fr.uga.l3miage.integrator.endpoints.EmployeEndPoints;
import fr.uga.l3miage.integrator.enums.Emploi;
import fr.uga.l3miage.integrator.responses.EmployeResponseDTO;
import fr.uga.l3miage.integrator.services.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


// Annotation indiquant que cette classe est un contrôleur Spring
@Controller
// Annotation Lombok qui crée automatiquement un constructeur pour toutes les dépendances finales requises
@RequiredArgsConstructor
// Déclaration de la classe contrôleur qui implémente l'interface des endpoints employés
public class EmployeController implements EmployeEndPoints {
    // Dépendance injectée pour le service des employés
    private final EmployeService employeService;

    // Implémentation du point de terminaison qui récupère tous les employés
    @Override
    public ResponseEntity<List<EmployeResponseDTO>> getAllEmployes() {
        // Récupérer tous les employés via le service des employés
        List<EmployeResponseDTO> allEmployes = employeService.getAllEmployes();
        // Retourner une réponse HTTP avec le statut 200 OK et la liste des employés
        return ResponseEntity.ok(allEmployes);
    }

    // Implémentation du point de terminaison qui récupère tous les livreurs
    @Override
    public Set<EmployeResponseDTO> getAllLivreurs() {
        // Récupérer les employés avec le rôle "livreur"
        return employeService.getEmployesByEmploi(Emploi.livreur);
    }

    // Implémentation du point de terminaison qui récupère les employés par rôle
    @Override
    public Set<EmployeResponseDTO> getEmployesByRole(Emploi emploi) {
        // Récupérer les employés selon le rôle donné en paramètre
        return employeService.getEmployesByEmploi(emploi);
    }

}
*/
@Controller
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class EmployeController implements EmployeEndPoints {
    private final EmployeService employeService;

    @Override
    public ResponseEntity<List<EmployeResponseDTO>> getAllEmployes() {
        List<EmployeResponseDTO> allEmployes = employeService.getAllEmployes();
        return ResponseEntity.ok(allEmployes);
    }

    /*@Override
    public Set<EmployeResponseDTO> getAllLivreurs() {
        return employeService.getEmployesByEmploi(Emploi.LIVREUR
    }

    @Override
    public Set<EmployeResponseDTO> getEmployesByRole(Emploi emploi) {
        return employeService.getEmployesByEmploi(emploi);
    }*/
    @Override
    public Set<EmployeResponseDTO> getEmployesByRole(@PathVariable("emploi") String emploi) {
        Emploi role;
        switch (emploi.toLowerCase()) {
            case "livreurs":
                role = Emploi.LIVREUR;
                break;
            case "planificateur":
                role = Emploi.PLANIFICATEUR;
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + emploi);
        }
        return employeService.getEmployesByEmploi(role);
    }


    @Override
    public EmployeResponseDTO creatEmploye(@RequestBody EmployeCreationRequest employeCreationRequest){
        return employeService.creatEmploye(employeCreationRequest);
    }



}

