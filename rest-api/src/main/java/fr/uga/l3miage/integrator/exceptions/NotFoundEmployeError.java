package fr.uga.l3miage.integrator.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotFoundEmployeError {
    private String message;  // Le message d'erreur décrivant ce qui s'est mal passé
    private TypeError typeError;  // Le type d'erreur

    public enum TypeError {  // Enumération des types d'erreurs
        EMPLOYE_NOT_FOUND,  // Erreur indiquant que l'employé n'a pas été trouvé
        INVALID_INPUT  // Erreur indiquant une entrée invalide
    }
}
