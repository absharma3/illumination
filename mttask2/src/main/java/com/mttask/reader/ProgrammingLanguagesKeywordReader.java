package com.mttask.reader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abhimanyus on 2/9/18.
 */
public class ProgrammingLanguagesKeywordReader extends AbstractKeywordReader {



    public ProgrammingLanguagesKeywordReader(String filePath) {
        super(filePath);

    }

    public List<String> read() {

        List<String> keywords = new ArrayList<String>();
        LineIterator it = this.readFile();;
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                if(line != null && !StringUtils.isAllEmpty(line))
                keywords.add(line);
            }
            return keywords;
        } finally {
            if (it != null)
                LineIterator.closeQuietly(it);
        }
    }
}
