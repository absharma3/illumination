package com.refactor.model;

import com.refactor.helper.CBRentCalculationHelper;
import com.refactor.helper.IRentCalculationHelper;

import java.util.Date;

/**
 * Created by abhimanyus on 2/5/18.
 */
public class ChildrensBook extends Book {


    public ChildrensBook(String title, Date releaseDate) {
        super(title, releaseDate);
    }

    @Override
    public IRentCalculationHelper getRentCalculationHelper() {
        return new CBRentCalculationHelper();
    }
}
