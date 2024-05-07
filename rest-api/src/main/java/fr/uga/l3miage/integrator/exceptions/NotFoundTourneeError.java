package fr.uga.l3miage.integrator.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotFoundTourneeError {
    private String message;  // Message de l'erreur
    private TypeError typeError;  // Type de l'erreur

    public enum TypeError {  // Enumération des types d'erreurs
        TOURNEE_NOT_FOUND,  // Erreur indiquant que la tournée n'a pas été trouvée
        INVALID_REFERENCE  // Erreur indiquant une référence invalide
    }
}
