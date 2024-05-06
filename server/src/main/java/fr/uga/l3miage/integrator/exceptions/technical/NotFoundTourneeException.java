package fr.uga.l3miage.integrator.exceptions.technical;

public class NotFoundTourneeException extends Exception {  // Hérite de la classe Exception
    public NotFoundTourneeException(String message) {  // Constructeur avec un message
        super(message);  // Appelle le constructeur de la classe parente
    }
}
