package com.observer.models;

/**
 * Created by abhimanyus on 2/21/18.
 */
public class CaseStudy extends Article{

    public CaseStudy(Blog parentBlog) {
        super(parentBlog);
    }

    public boolean isCaseStudy(){
        return true;
    }
}
