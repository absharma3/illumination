package com.annotations.exceptions;

/**
 * Created by abhimanyus on 2/22/18.
 */
public class ConsistencyValidationException extends RuntimeException{

    public ConsistencyValidationException(String message) {
        super(message);
    }
}
