package com.mttask.writer;

import com.mttask.http.model.KeywordDetail;

/**
 * Created by abhimanyus on 2/7/18.
 *
 * Interface to write keyword details to different files
 *
 */
public interface KeywordDetailWriter {

    public String write(KeywordDetail keywordDetail);

}
