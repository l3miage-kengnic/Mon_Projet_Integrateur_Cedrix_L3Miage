package fr.uga.l3miage.integrator.exceptions.handlers;

import fr.uga.l3miage.integrator.exceptions.NotFoundLivraisonsError;
import fr.uga.l3miage.integrator.exceptions.rest.NotFoundLivraisonsRestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class LivraisonsRestExceptionHandler {

    @ExceptionHandler(NotFoundLivraisonsRestException.class)
    public ResponseEntity<NotFoundLivraisonsError> handleNotFoundLivraisons(HttpServletRequest request, NotFoundLivraisonsRestException exception) {
        NotFoundLivraisonsError error = NotFoundLivraisonsError.builder()
                .message("La livraison demandée n'a pas été trouvée.")
                .typeError(NotFoundLivraisonsError.TypeError.NOT_FOUND)
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
