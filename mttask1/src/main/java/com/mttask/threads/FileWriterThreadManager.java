package com.mttask.threads;

import com.mttask.constants.MtTaskConstants;
import com.mttask.model.BookDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by abhimanyus on 2/6/18.
 * This class
 *
 *
 */
public class FileWriterThreadManager {

    private AtomicInteger fileCount = new AtomicInteger();
    private ForkJoinPool threadPool = new ForkJoinPool();
    private List<String> returnValList = new ArrayList<String>();

    public void spawnThreadsForWrite(List<BookDetails> listOfBooks) {
        fileCount.getAndAdd(1);
        FileWriterRecursiveTask wtf = new FileWriterRecursiveTask( MtTaskConstants.WRITE_FILE_NAME.toString() + fileCount + MtTaskConstants.FILE_EXTENSION.toString(),listOfBooks);
        String returnVals = threadPool.invoke(wtf);
        returnValList.add(returnVals);
    }

}
