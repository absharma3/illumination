package com.refactor.helper;

import com.refactor.model.Rental;

/**
 * Created by abhimanyus on 2/5/18.
 */
public class NFBRentCalculationHelper implements IRentCalculationHelper {

    @Override
    public double calculate(Rental rental) {
        double thisAmount =0;
        thisAmount += rental.getDaysRented() * 3;
         return thisAmount;
    }
}
