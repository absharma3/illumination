package com.refactor.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by abhimanyus on 2/6/18.
 *
 * Rental details for a particular book
 *
 */

public class Rental implements Serializable {

    private static final long serialVersionUID = 1256869448913370768L;
    private Book book;
    private int daysRented;
    private UUID id;

    public Rental(Book book, int daysRented) {
        super();
        this.id = UUID.randomUUID();
        this.book = book;
        this.daysRented = daysRented;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rental rental = (Rental) o;

        return id.equals(rental.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}