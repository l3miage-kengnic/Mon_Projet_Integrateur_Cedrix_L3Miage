package fr.uga.l3miage.integrator.exceptions.rest;

import lombok.Getter;

@Getter
public class NotFoundLivraisonsRestException extends RuntimeException {
    private final Type type;

    public NotFoundLivraisonsRestException(String message, Type type) {
        super(message);
        this.type = type;
    }

    public enum Type {
        NOT_FOUND,
        GENERAL
    }
}
