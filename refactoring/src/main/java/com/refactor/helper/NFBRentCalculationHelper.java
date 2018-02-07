package com.refactor.helper;

import com.refactor.model.Rental;

/**
 * Created by abhimanyus on 2/5/18.
 * Helper class for rent calculation in case of non fictional book
 *
 */
public class NFBRentCalculationHelper implements IRentCalculationHelper {

    @Override
    public double calculate(Rental rental) {
        double thisAmount =0;
        thisAmount += rental.getDaysRented() * 3;
         return thisAmount;
    }
}
