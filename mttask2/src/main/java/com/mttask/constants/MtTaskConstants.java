package com.mttask.constants;

/**
 * Created by abhimanyus on 2/22/18.
 */
public enum MtTaskConstants {

    JAVA_KEYWORDS_FILE_PATH("/Users/abhimanyus/Desktop/Nonsense/base/illumination/mttask2/Multithreading_Task_2_java Keywords.txt"),
    COMPANY_KEYWORDS_FILE_PATH("/Users/abhimanyus/Desktop/Nonsense/base/illumination/mttask2/Multithreading_Task_2_fortune1000companies.txt"),
    LANGUAGE_KEYWORDS_FILE_PATH("/Users/abhimanyus/Desktop/Nonsense/base/illumination/mttask2/Multithreading_Task2_ProgrammingLanguages.txt");


    private String value;
    MtTaskConstants(String s) {
        this.value = s;
    }


    @Override
    public String toString() {
        return value;
    }
}
