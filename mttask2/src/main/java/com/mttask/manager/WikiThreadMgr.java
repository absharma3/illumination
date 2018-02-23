package com.mttask.manager;

import com.mttask.http.model.KeywordDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by abhimanyus on 2/19/18.
 */
public class WikiThreadMgr {

    ExecutorService executor = Executors.newCachedThreadPool();

    public void invokeWikiAndWrite(List<String> keywords){
        List<Future<String>> returnVals = new ArrayList<Future<String>>();
        for (String keyword: keywords) {
            WikiInvokerAndWriter invokableTask = new WikiInvokerAndWriter(keyword);
             returnVals.add(executor.submit(invokableTask));
        }
        for(Future<String> future : returnVals) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                //TODO should have a logger or a better way of handling
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdownNow();
    }

}
