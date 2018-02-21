package com.generics.enums;

/**
 * Created by abhimanyus on 2/21/18.
 */

public class GenericTypes<S>{

    public static final GenericTypes<StringTypes> STRINGS =
            new GenericTypes<StringTypes>(StringTypes.class);

    public static final GenericTypes<NumberTypes> NUMBERS =
            new GenericTypes<NumberTypes>(NumberTypes.class);

    private final Class<S> javaType;

    public GenericTypes(Class<S> javaType) {
        this.javaType = javaType;
    }
    public Class<S> getJavaType() {
        return javaType;
    }

    public static <T> GenericTypes<?> get(T s) {

        if (StringTypes.getType(s) != null) {
            return STRINGS;
        } else if (NumberTypes.getType(s) != null) {
            return NUMBERS;
        }
        return null;
    }

}