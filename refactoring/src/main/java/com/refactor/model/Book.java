package com.refactor.model;
/**
 * Created by abhimanyus on 2/2/18.
 */

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {

    private static final long serialVersionUID = -7348792584072115788L;

    public static final int FICTION = 1;
    public static final int NON_FICTION = 2;
    public static final int CHILDRENS = 3;
    private Date releaseDate;

    private long id;
    private String title;
    private int bookCategory;

    public Book(final String title, final int bookCategory, final Date releaseDate) {
        super();
        this.title = title;
        this.bookCategory = bookCategory;
        this.releaseDate = releaseDate;
    }

    public Book(final String title, final int bookCategory) {
        super();
        this.title = title;
        this.bookCategory = bookCategory;
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

    public int getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(int bookCategory) {
        this.bookCategory = bookCategory;
    }

}
