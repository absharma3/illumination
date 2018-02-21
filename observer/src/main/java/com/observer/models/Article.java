package com.observer.models;

import com.observer.logic.ObservationManager;
import com.observer.logic.ObservationManagerFactory;

/**
 * Created by abhimanyus on 2/21/18.
 */
public class Article {

    private String name;
    private String description;
    private String body;

    private Blog parentBlog;

    private ObservationManager observationManager = ObservationManagerFactory.getObservationMgr();

    public Article(Blog parentBlog) {
        this.parentBlog = parentBlog;
    }

    public Blog getParentBlog() {
        return parentBlog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isCaseStudy(){
        return false;
    }

    public void update(){
        //Some more code which needs to be performed when object is updated
        observationManager.notifyUser(this);
        observationManager.notifyUser(this.getParentBlog());
    }

}
