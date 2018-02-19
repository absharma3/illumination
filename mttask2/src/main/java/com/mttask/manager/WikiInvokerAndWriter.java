package com.mttask.manager;

import com.mttask.http.WikiKeywordDetailGatherer;
import com.mttask.http.model.KeywordDetail;
import com.mttask.writer.KeywordDetailFileWriter;
import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by abhimanyus on 2/19/18.
 */
public class WikiInvokerAndWriter implements Callable<String> {


    private String keyword;
    private WikiKeywordDetailGatherer keywordDetailGatherer = new WikiKeywordDetailGatherer();
    private KeywordDetailFileWriter keywordDetailFileWriter = new KeywordDetailFileWriter();

    public WikiInvokerAndWriter(String keyword) {
        this.keyword = keyword;
    }

    public String call() throws Exception {
        KeywordDetail keywordDetails = keywordDetailGatherer.fetchInfo(this.keyword);
        return keywordDetailFileWriter.write(keywordDetails);
    }
}
