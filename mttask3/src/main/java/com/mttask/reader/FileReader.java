package com.mttask.reader;

import com.mttask.trie.Trie;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by abhimanyus on 2/20/18.
 */
public class FileReader implements Callable<Boolean> {

    private File file = null;

    public FileReader(File file) {
        this.file = file;
    }

    @Override
    public Boolean call() {

        if (!Thread.holdsLock(file)) {
            List<String> words = new ArrayList<String>();
            synchronized (file) {
                try {
                    List<String> lines = FileUtils.readLines(file, "UTF-16");
                    for (String line : lines) {
                        Collections.addAll(words, line.split("[\\\\s]+"));
                    }
                    for (String word : words) {
                        Trie.INSTANCE.insert(word);
                    }
                    FileInformationGatherer.INSTANCE.removeFile(file);
                    return true;

                } catch (IOException e) {
                    return false;
                }
            }
        }
        return true;

    }
}
