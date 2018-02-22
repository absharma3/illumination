package com.annotations.controller;

import com.annotations.exceptions.ConsistencyValidationException;
import com.annotations.exceptions.FieldValidationException;
import com.annotations.validator.CommonField;
import com.annotations.validator.CommonFieldNames;
import com.sun.tools.javac.util.Assert;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhimanyus on 2/22/18.
 */
public class DocumentConsistencyValidator {


    public List<ConsistencyValidationException> validateConsistency(Object instance1, Object instance2) throws IllegalAccessException {

        Assert.checkNonNull(instance1);
        Assert.checkNonNull(instance2);

        List<ConsistencyValidationException> exceptions = new ArrayList<ConsistencyValidationException>();
        CommonFieldNames[] values = CommonFieldNames.values();
        for(Field field1: instance1.getClass().getFields()){
            for(Field field2 : instance2.getClass().getFields()){
                if(field1.getAnnotation(CommonField.class).equals(field2.getAnnotation(CommonField.class))){
                    if(!field1.get(instance1).equals(field2.get(instance2))){
                        exceptions.add(new ConsistencyValidationException("The field " + field1.getName() + " of document "
                        + instance1.getClass().getName() + " and " + instance2.getClass().getName() + " are different"));
                    }
                }

            }


        }
        return exceptions;

    }

}
