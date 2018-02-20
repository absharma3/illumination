package com.mttask.reader;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by abhimanyus on 2/20/18.
 */
public class FileReaderThreadMgr {


    ExecutorService executor = Executors.newCachedThreadPool();


    public void readFiles(){
        File readableFile =  null;
        readableFile = FileInformationGatherer.INSTANCE.getRandomFile();
        while(Thread.holdsLock(readableFile)){
            readableFile = FileInformationGatherer.INSTANCE.getRandomFile();
        }

        FileReader callableFileReader = new FileReader(readableFile);
        Future<Boolean> executionStatus = executor.submit(callableFileReader);



    }



}
