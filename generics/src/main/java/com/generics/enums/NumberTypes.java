package com.generics.enums;

/**
 * Created by abhimanyus on 2/21/18.
 */
public enum NumberTypes {


    ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7);
    private Integer number;
    NumberTypes(int number) {
        this.number=number;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public static <T> NumberTypes getType(T number) {
        for (NumberTypes category : values()) {
            if (category.getNumber().equals(number)) {
                return category;
            }
        }
        return null;
    }

}
