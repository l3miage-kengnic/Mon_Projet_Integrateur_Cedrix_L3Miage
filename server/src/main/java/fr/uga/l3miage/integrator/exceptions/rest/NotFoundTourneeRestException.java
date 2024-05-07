package fr.uga.l3miage.integrator.exceptions.rest;

import lombok.Getter;

@Getter  // Génère des getters pour les attributs de la classe
public class NotFoundTourneeRestException extends RuntimeException {  // Hérite de RuntimeException
    private final String reference;  // Référence de la tournée qui n'a pas été trouvée

    public NotFoundTourneeRestException(String reference) {  // Constructeur de l'exception
        super("Tournée avec la référence " + reference + " n'a pas été trouvée.");  // Message de l'exception
        this.reference = reference;  // Stocke la référence
    }
}
