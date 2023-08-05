package com.meli.login.domain.excepcion;

public abstract class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }
}
