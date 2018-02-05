package com.refactor.model;

import com.refactor.helper.IRentCalculationHelper;

import java.util.Date;

/**
 * Created by abhimanyus on 2/5/18.
 */
public interface IBook {

    Date getReleaseDate();
    long getId();
    String getTitle();
    IRentCalculationHelper getRentCalculationHelper();


}
