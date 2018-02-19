package com.mttask.reader;

import org.apache.commons.io.LineIterator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abhimanyus on 2/9/18.
 */
public class CompanyKeywordReader extends AbstractKeywordReader {


    public CompanyKeywordReader(String filePath) {
        super(filePath);
    }

    public List<String> read() {
        List<String> keywords = new ArrayList<String>();
        LineIterator it = this.readFile();
        try {
            it.nextLine();
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] lineData = line.split("\t");
                keywords.add(lineData[1]);

            }
            return keywords;
        }  finally {
            if (it != null)
                LineIterator.closeQuietly(it);
        }
    }
}
