package com.mttask.controller;

import com.mttask.constants.MtTaskConstants;
import com.mttask.manager.WikiThreadMgr;
import com.mttask.reader.CommaSaperatedKeywordsReader;
import com.mttask.reader.KeywordsReader;
import com.mttask.reader.LineSaperatedKeywordReader;
import com.mttask.reader.TabSaperatedKeywordReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhimanyus on 2/19/18.
 */
public class MtTaskController {

    public static void main(String [] args){
        List<String> keywords = new ArrayList<String>();
        KeywordsReader javaKeywordsReader = new CommaSaperatedKeywordsReader(MtTaskConstants.JAVA_KEYWORDS_FILE_PATH.toString());
        KeywordsReader companyKeywordsReader = new TabSaperatedKeywordReader(MtTaskConstants.COMPANY_KEYWORDS_FILE_PATH.toString());
        KeywordsReader languagesKeywordsReader = new LineSaperatedKeywordReader(MtTaskConstants.LANGUAGE_KEYWORDS_FILE_PATH.toString());
        keywords.addAll(javaKeywordsReader.read());
        keywords.addAll(companyKeywordsReader.read());
        keywords.addAll(languagesKeywordsReader.read());
        WikiThreadMgr wikiInvoker = new WikiThreadMgr();
        wikiInvoker.invokeWikiAndWrite(keywords);


    }

}
