package com.annotations.validator;

/**
 * Created by abhimanyus on 2/22/18.
 */
public interface Validator<T> {

    boolean validate(T field);
}
