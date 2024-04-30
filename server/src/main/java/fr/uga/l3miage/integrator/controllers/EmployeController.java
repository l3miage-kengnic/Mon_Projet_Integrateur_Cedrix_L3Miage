package fr.uga.l3miage.integrator.controllers;

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

