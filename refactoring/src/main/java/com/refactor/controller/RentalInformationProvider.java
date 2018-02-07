package com.refactor.controller;

import com.refactor.dao.RentalsDao;
import com.refactor.model.Customer;
import com.refactor.model.FictionalBook;
import com.refactor.model.Rental;

import java.util.*;

/**
 * Created by abhimanyus on 2/6/18.
 * This class has the following responsibilities to fulfill
 * 1) Calculate rent amount of each book
 * 2) Calculate cumulative rent amount
 *
 */
public class RentalInformationProvider {

    private Customer customer;
    private double totalRentAmount = 0;

    public RentalInformationProvider(Customer customer) {
        this.customer = customer;
    }

    /**
     *@return the overall rent information related to all the rentals of a customer
     */

    public String generateStatement(){
        List<Rental> rentals = RentalsDao.getAllRentals(this.customer);
        Map<Rental, Double> rentalsAndItsRent = this.calculateRentForEachBookAndTotal(rentals);
        return buildStatement(rentalsAndItsRent);

    }

    /**
     *
     * @param rentalsAndItsRent map which contains Rentals and calculated rent
     * @return
     */

    private String buildStatement(Map<Rental, Double> rentalsAndItsRent) {

        StringBuilder result = new StringBuilder("Rental Record for " + this.customer.getName() + "\n");
        for(Map.Entry<Rental, Double>rentalAndRent: rentalsAndItsRent.entrySet()){
            result.append("\t").append(rentalAndRent.getKey().getBook().getTitle()).append("\t").append(rentalAndRent.getValue()).append("\n");
        }
        result.append("Amount owed is ").append(this.totalRentAmount).append("\n");
        result.append("You earned ").append(this.customer.getFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }


    /**
     *
     * @param rentals List of rentals for a particular customer
     * @return calculated rent amount for each rental
     */
    private Map<Rental, Double> calculateRentForEachBookAndTotal(List<Rental> rentals) {

        Map<Rental, Double> rentalsAndItsRent = new HashMap<Rental, Double>();
        double rentAmount = 0;
        for (Rental rental : rentals) {
            rentAmount = rental.getBook().getRentCalculationHelper().calculate(rental);
            totalRentAmount += rentAmount;
            if ((rental.getBook() instanceof FictionalBook) && rental.getDaysRented() > 1) {
                this.customer.setFrequentRenterPoints(this.customer.getFrequentRenterPoints() + 2);
            } else {
                this.customer.setFrequentRenterPoints(this.customer.getFrequentRenterPoints() + 1);
            }
        }

        return rentalsAndItsRent;
    }

}
