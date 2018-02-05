package com.refactor.model;
/**
 * Created by abhimanyus on 2/2/18.
 */

import java.io.Serializable;
import java.util.Date;

public abstract class Book implements Serializable, IBook {

    private static final long serialVersionUID = -7348792584072115788L;

    private Date releaseDate;
    private long id;
    private String title;

    public Book(final String title, final Date releaseDate) {
        super();
        this.id = 123456; //Some random id to be generated
        this.title = title;
        this.releaseDate = releaseDate;
    }


    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
