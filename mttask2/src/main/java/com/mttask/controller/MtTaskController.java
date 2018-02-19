package com.mttask.controller;

import com.mttask.reader.CompanyKeywordReader;
import com.mttask.reader.JavaKeywordsReader;
import com.mttask.reader.KeywordsReader;
import com.mttask.reader.ProgrammingLanguagesKeywordReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhimanyus on 2/19/18.
 */
public class MtTaskController {

    public static void main(String [] args){
        List<String> keywords = new ArrayList<String>();
        KeywordsReader javaKeywordsReader = new JavaKeywordsReader("/Users/abhimanyus/Desktop/Nonsense/base/illumination/mttask2/Multithreading_Task_2_java Keywords.txt");
        KeywordsReader companyKeywordsReader = new CompanyKeywordReader("/Users/abhimanyus/Desktop/Nonsense/base/illumination/mttask2/Multithreading_Task_2_fortune1000companies.txt");
        KeywordsReader languagesKeywordsReader = new ProgrammingLanguagesKeywordReader("/Users/abhimanyus/Desktop/Nonsense/base/illumination/mttask2/Multithreading_Task2_ProgrammingLanguages.txt");

        keywords.addAll(javaKeywordsReader.read());
        keywords.addAll(companyKeywordsReader.read());
        keywords.addAll(languagesKeywordsReader.read());



    }

}
