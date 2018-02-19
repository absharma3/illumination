package com.mttask.reader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by abhimanyus on 2/9/18.
 */
public abstract class AbstractKeywordReader implements KeywordsReader {

    private String filePath;

    public AbstractKeywordReader(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public LineIterator readFile() {
        try {
            LineIterator it = FileUtils.lineIterator(new File(this.getFilePath()), "UTF-8");
            return it;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
