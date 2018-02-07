package com.mttask.http;

import com.mttask.http.model.KeywordDetail;

/**
 * Created by abhimanyus on 2/7/18.
 * Interface to gather information related to keyword from different platforms
 *
 */
public interface KeywordDetailGatherer {

    public KeywordDetail fetchInfo(String keyword);


}
