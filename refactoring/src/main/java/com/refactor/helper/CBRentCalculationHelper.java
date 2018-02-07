package com.refactor.helper;

import com.refactor.model.Rental;

/**
 * Created by abhimanyus on 2/5/18.
 * Helper class for rent calculation in case of children's book
 *
 */
public class CBRentCalculationHelper implements IRentCalculationHelper {
    @Override
    public double calculate(Rental rental) {

        double thisAmount = 1.5;
        if (rental.getDaysRented() > 3)
            thisAmount += (rental.getDaysRented() - 3) * 2;
        return thisAmount;
    }
}
