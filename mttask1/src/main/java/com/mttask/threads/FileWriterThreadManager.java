package com.mttask.threads;

import com.mttask.constants.MtTaskConstants;
import com.mttask.model.BookDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;


/**
 * Created by abhimanyus on 2/6/18.
 * This class
 *
 *
 */
public class FileWriterThreadManager {

    private volatile int fileCount =0;
    private ForkJoinPool threadPool = new ForkJoinPool();
    private List<String> returnValList = new ArrayList<String>();

    public void spawnThreadsForWrite(List<BookDetails> listOfBooks) {
        fileCount ++;
        FileWriterRecursiveTask wtf = new FileWriterRecursiveTask( MtTaskConstants.WRITE_FILE_NAME.toString() + fileCount + MtTaskConstants.FILE_EXTENSION.toString(),listOfBooks);
        String returnVals = threadPool.invoke(wtf);
        returnValList.add(returnVals);
    }

}
