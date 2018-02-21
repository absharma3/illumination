package com.observer.models;

import com.observer.logic.ObservationManager;
import com.observer.logic.ObservationManagerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by abhimanyus on 2/21/18.
 */
public class Blog {


    private UUID id;
    private List<Article> articles = new ArrayList<Article>();
    private List<CaseStudy> caseStudiesList = new ArrayList<CaseStudy>();

    private ObservationManager observationManager = ObservationManagerFactory.getObservationMgr();

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<CaseStudy> getCaseStudiesList() {
        return caseStudiesList;
    }

    public void setCaseStudiesList(List<CaseStudy> caseStudiesList) {
        this.caseStudiesList = caseStudiesList;
    }

    public void update(){
        //Some more code which needs to be performed when object is updated
        observationManager.notifyUser(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Blog blog = (Blog) o;

        return id.equals(blog.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
