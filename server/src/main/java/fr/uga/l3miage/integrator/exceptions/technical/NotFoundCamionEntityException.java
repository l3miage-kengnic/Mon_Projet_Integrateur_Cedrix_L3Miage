package fr.uga.l3miage.integrator.exceptions.technical;


public class NotFoundCamionEntityException extends Exception{
    public NotFoundCamionEntityException(String format){
        super(format);
    }
}
