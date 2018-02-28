package com.mttask.threads;

import com.mttask.model.BookDetails;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.RecursiveTask;

/**
 * Created by abhimanyus on 2/1/18.
 * A thread to write book details into a text file.
 *
 */
public class FileWriterRecursiveTask extends RecursiveTask<String> {


    private final String fileName;
    private List<BookDetails> listOfBooks;

    public FileWriterRecursiveTask(String fileName, List<BookDetails> listOfBooks) {
        this.listOfBooks = listOfBooks;
        this.fileName =  fileName;
    }

    /**
     *
     * @return the whether a file is sucessfully created or not
     */
    @Override
    protected String compute() {
        StringBuilder builder = new StringBuilder();
        for (BookDetails book: listOfBooks) {
            builder.append(book.toString() + "\n");
        }

        try {
            FileUtils.write(new File(fileName), builder.toString(), "UTF-16");
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Sucessful processing of file" + this.fileName;
    }
}
