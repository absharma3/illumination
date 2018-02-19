package com.mttask.http.model;

/**
 * Created by abhimanyus on 2/7/18.
 * POJO to gather keyword details
 *
 */
public class KeywordDetail {


    private String keywordName;
    private String keywordDescription;


    public KeywordDetail(String keywordName, String keywordDescription) {
        this.keywordName = keywordName;
        this.keywordDescription = keywordDescription;
    }

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public String getKeywordDescription() {
        return keywordDescription;
    }

    public void setKeywordDescription(String keywordDescription) {
        this.keywordDescription = keywordDescription;
    }

    @Override
    public String toString() {
        return "KeywordDetail{" +
                "keywordName='" + keywordName + '\'' +
                ", keywordDescription='" + keywordDescription + '\'' +
                '}';
    }
}
