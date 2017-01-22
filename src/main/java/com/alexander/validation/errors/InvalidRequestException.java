package com.alexander.validation.errors;

import org.springframework.validation.Errors;

/**
 * Created by alex on 12.01.2017.
 */
@SuppressWarnings("serial")
public class InvalidRequestException extends RuntimeException {
    private Errors errors;

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() { return errors; }
}
