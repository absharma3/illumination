package com.annotations.controller;

import com.annotations.exceptions.FieldValidationException;
import com.annotations.validator.FieldType;
import com.annotations.validator.Validate;
import com.annotations.validator.Validator;
import com.sun.tools.javac.util.Assert;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhimanyus on 2/22/18.
 */
public class DocumentFieldValidator {

    public List<FieldValidationException> validateObjectFields(Object instance) throws IllegalAccessException {

        Assert.checkNonNull(instance);
        List<FieldValidationException> exceptions = new ArrayList<FieldValidationException>();
        Field[] fields = instance.getClass().getDeclaredFields();

        for (Field field : fields) {
            Validate annotation = field.getAnnotation(Validate.class);
            Validator validator = annotation.id().getValidator();

            boolean isValid = validator.validate(field.get(instance));
            if (!isValid) {
                exceptions.add(new FieldValidationException(field.get(instance).toString() + " is not valid and as per " +
                        validator.getClass().getName()));


            }

        }
        return exceptions;
    }
}
