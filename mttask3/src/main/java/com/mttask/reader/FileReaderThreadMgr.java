package com.mttask.reader;

import com.mttask.constants.MtTaskConstants;
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

    private List<File> filesList = new ArrayList<File>();

    public void readFiles(){

        while (!filesList.isEmpty()) {
            FileReader callableFileReader = new FileReader(filesList.get(0), filesList);
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
        File directory = new File(String.valueOf(MtTaskConstants.FILE_DIRECTORY));
        //get all the files from a directory
        File[] fList = directory.listFiles();
        Collections.addAll(filesList,fList);
    }

}
