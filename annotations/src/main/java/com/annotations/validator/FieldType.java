package com.annotations.validator;

/**
 * Created by abhimanyus on 2/22/18.
 */
public enum FieldType {
    STRING(String.class, new StringValidator());

    private final Class clazz;
    private final Validator validator;

    <T> FieldType(Class clz, Validator<T> V) {
        this.clazz = clz;
        this.validator = V;
    }

    public Class getClazz() {
        return clazz;
    }

    public Validator getValidator() {
        return validator;
    }
}
