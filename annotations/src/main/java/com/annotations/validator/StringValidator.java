package com.annotations.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by abhimanyus on 2/22/18.
 */
public class StringValidator implements Validator<String> {

    public boolean validate(String field){

        Pattern pattern = Pattern.compile("^[\\p{L} .'-]+$");
        Matcher matcher = pattern.matcher(field);

        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
