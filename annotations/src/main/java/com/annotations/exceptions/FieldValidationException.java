package com.annotations.exceptions;

/**
 * Created by abhimanyus on 2/22/18.
 */
public class FieldValidationException extends RuntimeException {


    public FieldValidationException(String message) {
        super(message);
    }
}
