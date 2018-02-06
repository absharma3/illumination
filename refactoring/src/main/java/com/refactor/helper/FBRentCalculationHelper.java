package com.refactor.helper;

import com.refactor.model.Rental;

/**
 * Created by abhimanyus on 2/5/18.
 */
public class FBRentCalculationHelper implements IRentCalculationHelper {
    @Override
    public double calculate(Rental rental) {

        double thisAmount = 2;
        if (rental.getDaysRented() > 2)
            thisAmount += (rental.getDaysRented() - 2) * 1.5;
        return thisAmount;

    }
}
