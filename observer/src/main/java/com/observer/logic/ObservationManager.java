package com.observer.logic;

import com.observer.models.Article;
import com.observer.models.Blog;
import com.observer.models.CaseStudy;
import com.observer.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by abhimanyus on 2/21/18.
 */
public class ObservationManager {

    private Map<Blog, List<User>> blogSubscribedUsers = new HashMap<Blog, List<User>>();
    private Map<Article, List<User>> articleSubscribedUsers = new HashMap<Article, List<User>>();
    private Map<CaseStudy, List<User>> caseStudySubscribedUsers = new HashMap<CaseStudy, List<User>>();


    public void subscribe(User user, Blog blog){
        List<User> users= blogSubscribedUsers.get(blog);
        if(users == null){
            users = new ArrayList<User>();
            users.add(user);
        }else{
            users.add(user);
        }
    }

    public void subcribe(User user, Article article){
        List<User> users = null;
        if(article instanceof CaseStudy){
            users = caseStudySubscribedUsers.get(article);
        }else {
            users = articleSubscribedUsers.get(article);
        }
        if(users == null){
            users = new ArrayList<User>();
            users.add(user);
            subscribe(user, article.getParentBlog());
        }else{
            users.add(user);
            subscribe(user, article.getParentBlog());
        }
    }


    public void notifyUser(Blog blog) {
        List<User> users= blogSubscribedUsers.get(blog);
        if(users != null){
            for(User user : users){
                //The following code can be delegated to some helper class
                //user.performSomeAction();
            }
        }


    }

    public void notifyUser(Article article) {
        List<User> users= null;
        if(article instanceof CaseStudy){
            users = caseStudySubscribedUsers.get(article);
        }else {
            users = articleSubscribedUsers.get(article);
        }

        if(users != null){
            for(User user : users){
                //The following code can be delegated to some helper class
                //user.performSomeAction();
            }
        }

    }
}
