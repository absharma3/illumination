package com.mttask.constants;

/**
 * Created by abhimanyus on 2/6/18.
 * List of constants used across project.
 *
 */
public enum MtTaskConstants {

    READFILENAME("/Users/abhimanyus/Desktop/Nonsense/OfficeTasks/MultiThreading1/Multithreading_Task1_Books.csv"),
    LINESTHRESHOLD("10"),
    DATEFORMAT("yyyy.MM.dd.HH.mm.ss"),
    WRITE_FILE_NAME("/Users/abhimanyus/Desktop/Nonsense/OfficeTasks/MultiThreading1/Books"),
    FILE_EXTENSION(".txt");




    private final String text;
    MtTaskConstants(String s) {
        this.text = s;
    }

    @Override
    public String toString() {
        return text;
    }


}
