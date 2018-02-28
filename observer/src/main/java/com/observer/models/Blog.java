package com.observer.models;

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
    }
}
