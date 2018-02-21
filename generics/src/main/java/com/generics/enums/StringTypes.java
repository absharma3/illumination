package com.generics.enums;

/**
 * Created by abhimanyus on 2/21/18.
 */
public enum StringTypes {


    DEFAULT("default"), NONDEFAULT("nondefault"), STRING1("string1");
    private String someString;

    StringTypes(String someString) {
        this.someString = someString;
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public static <T> StringTypes getType(T string) {
        for (StringTypes category : values()) {
            if (category.getSomeString().equals(string)) {
                return category;
            }
        }
        return null;
    }



}
