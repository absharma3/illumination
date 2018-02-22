package com.annotations.validator;

/**
 * Created by abhimanyus on 2/22/18.
 */
public enum FieldType {
    STRING(new StringValidator()), PAN_NUMBER(new PanNumberValidator());


    private final Validator validator;

    <T> FieldType(Validator<T> V) {
        this.validator = V;
    }

    public Validator getValidator() {
        return validator;
    }
}
