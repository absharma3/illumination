package com.refactor.model;

import com.refactor.helper.IRentCalculationHelper;
import com.refactor.helper.NFBRentCalculationHelper;

import java.util.Date;

/**
 * Created by abhimanyus on 2/5/18.
 */
public class NonFictionalBook extends Book{
    public NonFictionalBook(String title, Date releaseDate) {
        super(title, releaseDate);
    }

    @Override
    public IRentCalculationHelper getRentCalculationHelper() {
        return new NFBRentCalculationHelper();
    }
}
