package com.annotations.validator;

/**
 * Created by abhimanyus on 2/22/18.
 */
public enum CommonFieldNames {

    FULLNAME("fullname"), FATHER_NAME("father");

    private String fieldName;

    CommonFieldNames(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName(){
        return this.fieldName;
    }
}
