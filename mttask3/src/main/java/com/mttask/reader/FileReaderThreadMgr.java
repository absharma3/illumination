package com.mttask.reader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by abhimanyus on 2/20/18.
 */
public class FileReaderThreadMgr {
    private ExecutorService executor = Executors.newCachedThreadPool();
    private List<Future<Boolean>> executionStatuses = new ArrayList<Future<Boolean>>();

    private static final String fileDirectory = "/Users/abhimanyus/Desktop/Nonsense/base/dump/";
    private List<File> filesList = new ArrayList<File>();
    private String [] extentions = {".txt"};

    public void readFiles(){
        File readableFile =  null;
        readableFile = this.getRandomFile();
        while(Thread.holdsLock(readableFile)){
            readableFile = this.getRandomFile();
        }

        FileReader callableFileReader = new FileReader(readableFile, filesList);
        Future<Boolean> executionStatus = executor.submit(callableFileReader);
        executionStatuses.add(executionStatus);

    }

    public FileReaderThreadMgr() {
        filesList.addAll(FileUtils.listFiles(new File(fileDirectory), extentions , false));
    }

    public File getRandomFile(){
        int size = filesList.size();
        int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
        File file = filesList.get(item);
        return file;
    }

}
