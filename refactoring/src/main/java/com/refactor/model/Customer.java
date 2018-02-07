package com.refactor.model;

import com.refactor.model.Book;
import com.refactor.model.FictionalBook;
import com.refactor.model.Rental;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Customer class that denotes customer details as well as customer related
 * operations.
 *
 * @author abhimanyus
 *
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 851426779607326255L;

    private long id;
    private String name;
    private int frequentRenterPoints = 0;

    private List<Rental> rentals = new ArrayList<Rental>();


    public Customer(String name) {
        super();
        this.name = name;

    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public void setFrequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void addRental(final Rental rental) {
        getRentals().add(rental);
    }

}