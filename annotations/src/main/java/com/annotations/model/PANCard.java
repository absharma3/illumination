package com.annotations.model;

import com.annotations.validator.FieldType;
import com.annotations.validator.Validate;


import java.util.Date;

/**
 * Created by abhimanyus on 2/22/18.
 */
public class PANCard {

    @Validate(id= FieldType.STRING)
    private String fullname;
    @Validate(id=FieldType.STRING)
    private String fatherName;
    @Validate(id=FieldType.PAN_NUMBER)
    private String panNumber;
    @Validate(id=FieldType.STRING)
    private String issuedBy;
    private Date dob;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


}
