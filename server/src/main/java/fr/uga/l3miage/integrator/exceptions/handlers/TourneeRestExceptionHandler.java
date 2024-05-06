package fr.uga.l3miage.integrator.exceptions.handlers;

import fr.uga.l3miage.integrator.exceptions.NotFoundTourneeError;
import fr.uga.l3miage.integrator.exceptions.rest.NotFoundTourneeRestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  // Conseiller pour gérer les exceptions dans les contrôleurs REST
public class TourneeRestExceptionHandler {

    @ExceptionHandler(NotFoundTourneeRestException.class)  // Gestionnaire d'exception pour NotFoundTourneeRestException
    ResponseEntity<NotFoundTourneeError> handle(NotFoundTourneeRestException exception) {
        // Créer l'objet d'erreur à partir de l'exception
        NotFoundTourneeError error = NotFoundTourneeError.builder()
                .message("La tournée avec la référence " + exception.getReference() + " n'a pas été trouvée.")
                .typeError(NotFoundTourneeError.TypeError.TOURNEE_NOT_FOUND)  // Spécifie le type d'erreur
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);  // Retourne une réponse 404 avec l'erreur
    }
}
