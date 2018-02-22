package com.annotations.model;

import com.annotations.validator.FieldType;
import com.annotations.validator.Validate;
import java.util.Date;

/**
 * Created by abhimanyus on 2/22/18.
 */
public class Aadhaar {
    private int id;
    @Validate(id= FieldType.STRING)
    private String fullname;
    @Validate(id= FieldType.STRING)
    private String gender;
    @Validate(id= FieldType.STRING)
    private String address;
    private Date dob;

    public Aadhaar() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
