package fr.uga.l3miage.integrator.exceptions.handlers;

import fr.uga.l3miage.integrator.exceptions.NotFoundEmployeError;
import fr.uga.l3miage.integrator.exceptions.rest.NotFoundEmployeRestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice  // Conseiller pour gérer les exceptions dans les contrôleurs REST
public class EmployeRestExceptionHandler {

    @ExceptionHandler(NotFoundEmployeRestException.class)  // Gestionnaire d'exception pour NotFoundEmployeRestException
    ResponseEntity<NotFoundEmployeError> handle(HttpServletRequest request, NotFoundEmployeRestException exception) {
        // Créer l'objet d'erreur à partir de l'exception
        NotFoundEmployeError error = NotFoundEmployeError.builder()
                .message("L'employé avec le trigramme " + exception.getTrigramme() + " n'a pas été trouvé.")
                .typeError(NotFoundEmployeError.TypeError.EMPLOYE_NOT_FOUND)  // Spécifie le type d'erreur
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);  // Retourne une réponse 404 avec l'erreur
    }
}
