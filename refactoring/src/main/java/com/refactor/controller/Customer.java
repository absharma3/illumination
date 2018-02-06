package com.refactor.controller;

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

    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        super();
        this.name = name;
    }

    public String fetchStatement() {

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentalsItr = rentals.listIterator();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        while (rentalsItr.hasNext()) {
            double thisAmount = 0;
            Rental rental = (Rental) rentalsItr.next();

            // determine amounts for each book.
            thisAmount = rental.getBook().getRentCalculationHelper().calculate(rental);

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if ((rental.getBook() instanceof FictionalBook) && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental
            result.append("\t").append(rental.getBook().getTitle()).append("\t").append(String.valueOf(thisAmount)).append("\n");
            totalAmount += thisAmount;
        }

        result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n");
        result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");

        return result.toString();
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