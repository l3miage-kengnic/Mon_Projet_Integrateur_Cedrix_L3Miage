package fr.uga.l3miage.integrator.exceptions.rest;

import net.bytebuddy.implementation.bind.annotation.Super;

public class NotFoundEntityRestException extends RuntimeException{
    public NotFoundEntityRestException(String message){ super(message);}
}
