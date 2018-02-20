package com.mttask.reader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by abhimanyus on 2/20/18.
 */
public class FileInformationGatherer {

    private static final String fileDirectory = "/Users/abhimanyus/Desktop/Nonsense/base/dump/";
    private List<File> filesList;
    private String [] extentions = {".txt"};

    public static final FileInformationGatherer INSTANCE = new FileInformationGatherer();

    private FileInformationGatherer() {
        filesList.addAll(FileUtils.listFiles(new File(fileDirectory), extentions , false));
    }

    public File getRandomFile(){
        int size = filesList.size();
        int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
        File file = filesList.get(item);
        return file;
    }

    public void removeFile(File file){
        filesList.remove(file);
    }

}
