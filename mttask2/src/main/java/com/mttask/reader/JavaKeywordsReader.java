package com.mttask.reader;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abhimanyus on 2/9/18.
 */
public class JavaKeywordsReader extends AbstractKeywordReader {

    public JavaKeywordsReader(String filePath) {
        super(filePath);

    }

    public List<String> read() {
        List<String> keywords = new ArrayList<String>();
        LineIterator it = this.readFile();
        try {
            it.nextLine();
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] lineData = line.split(",");
                for(String word : lineData){
                    if(word != null && !(word.length() ==0)){
                        keywords.add(word);
                    }
                }

            }
            return keywords;
        }  finally {
            if (it != null)
                LineIterator.closeQuietly(it);
        }
    }

}
