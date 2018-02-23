package com.mttask.reader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by abhimanyus on 2/20/18.
 */
public class FileReaderThreadMgr {
    private ExecutorService executor = Executors.newFixedThreadPool(5);
    private List<Future<Boolean>> executionStatuses = new CopyOnWriteArrayList<>();

    private static final String fileDirectory = "/Users/abhimanyus/Desktop/Nonsense/base/dump/";
    private List<File> filesList = new ArrayList<File>();
    private String [] extentions = {".txt"};

    public void readFiles(){
        while(!filesList.isEmpty()) {
            File readableFile = null;
            readableFile = this.getRandomFile();
            while (Thread.holdsLock(readableFile)) {
                readableFile = this.getRandomFile();
            }

            FileReader callableFileReader = new FileReader(readableFile, filesList);
            Future<Boolean> executionStatus = executor.submit(callableFileReader);
            executionStatuses.add(executionStatus);
        }

        for(Future<Boolean> future : executionStatuses){
            try {
                future.get();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } catch (ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public FileReaderThreadMgr() {
        File directory = new File(fileDirectory);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        Collections.addAll(filesList,fList);
    }

    public File getRandomFile(){
        int size = filesList.size();
        int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
        File file = filesList.get(item);
        return file;
    }

}
