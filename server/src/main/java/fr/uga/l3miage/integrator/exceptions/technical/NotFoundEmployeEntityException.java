package fr.uga.l3miage.integrator.exceptions.technical;

public class NotFoundEmployeEntityException extends Exception {  // Hérite de la classe Exception
    public NotFoundEmployeEntityException(String message) {  // Constructeur avec un message
        super(message);  // Appelle le constructeur de la classe parente
    }
}
