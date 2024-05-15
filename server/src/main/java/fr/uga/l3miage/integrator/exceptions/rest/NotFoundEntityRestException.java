package fr.uga.l3miage.integrator.exceptions.rest;

import lombok.Getter;
import net.bytebuddy.implementation.bind.annotation.Super;
@Getter
public class NotFoundEntityRestException extends RuntimeException{
    public NotFoundEntityRestException(String message){ super(message);}
}
