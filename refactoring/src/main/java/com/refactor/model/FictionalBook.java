package com.refactor.model;

import com.refactor.helper.FBRentCalculationHelper;
import com.refactor.helper.IRentCalculationHelper;

import java.util.Date;

/**
 * Created by abhimanyus on 2/5/18.
 */
public class FictionalBook extends Book {
    public FictionalBook(String title, Date releaseDate) {
        super(title, releaseDate);
    }

    @Override
    public IRentCalculationHelper getRentCalculationHelper() {
        return new FBRentCalculationHelper();
    }
}
