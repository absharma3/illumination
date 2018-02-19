package com.mttask.manager;

import com.mttask.http.model.KeywordDetail;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by abhimanyus on 2/19/18.
 */
public class WikiThreadMgr {

    ExecutorService executor = Executors.newCachedThreadPool();

    public void invokeWikiAndWrite(List<String> keywords){
        for (String keyword: keywords) {
            WikiInvokerAndWriter invokableTask = new WikiInvokerAndWriter(keyword);
            Future<String> returnVal = executor.submit(invokableTask);
        }

    }

}
