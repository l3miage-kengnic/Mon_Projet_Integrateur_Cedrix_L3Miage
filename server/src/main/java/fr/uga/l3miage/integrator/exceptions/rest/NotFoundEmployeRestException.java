package fr.uga.l3miage.integrator.exceptions.rest;

import lombok.Getter;

@Getter  // Génère des getters pour les attributs de la classe
public class NotFoundEmployeRestException extends RuntimeException {  // Hérite de RuntimeException
    private final String trigramme;  // Trigramme de l'employé qui n'a pas été trouvé

    public NotFoundEmployeRestException(String trigramme) {  // Constructeur de l'exception
        super("Employé avec le trigramme " + trigramme + " n'a pas été trouvé.");  // Message de l'exception
        this.trigramme = trigramme;  // Stocke le trigramme
    }
}
