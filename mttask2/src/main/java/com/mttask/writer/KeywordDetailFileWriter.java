package com.mttask.writer;

import com.mttask.http.model.KeywordDetail;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by abhimanyus on 2/19/18.
 */
public class KeywordDetailFileWriter implements KeywordDetailWriter {


    private String fileLocation = "/Users/abhimanyus/Desktop/Nonsense/base/dump/";
    private String extention = ".txt";

    public String write(KeywordDetail keywordDetail) {
        String filePath = fileLocation + keywordDetail.getKeywordName() + extention;

        try {
            FileUtils.write(new File(filePath), keywordDetail.toString(), "UTF-16");
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
