package com.mttask.helper;


import com.mttask.model.BookDetails;
import com.mttask.threads.FileWriterThreadManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * TODO need to split the code of thread creation from data read
 * Created by abhimanyus on 2/1/18.
 */
public class CSVHelper {

    FileWriterThreadManager controller = new FileWriterThreadManager();
    int threshold = 0;
    public CSVHelper(int threshold) {
        this.threshold = threshold;
    }


    /**
     *
     * The main objective of this method is to read a CSV, create a book details object
     * spawn a new thread to write the the data if the number of books read reach a certain threshold.
     *
     * @param filePath refers to the file location that needs to be read
     * @throws IOException is thrown in case we are not able to read the file
     */

    public void readAndExecute(String filePath) throws IOException {

        int currentCounter = 0;
        List<BookDetails> listOfBooks = new ArrayList<BookDetails>();

        LineIterator it = FileUtils.lineIterator(new File(filePath), "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                String[] lineData = line.split(";");
                BookDetails book = new BookDetails(lineData[0], lineData[1],lineData[2], lineData[3],lineData[4],lineData[5],lineData[6],lineData[7] );
                if(currentCounter == threshold){
                    //spawn thread
                    //reset current counter
                    //reset list of books
                    controller.spawnThreadsForWrite(listOfBooks);
                    currentCounter = 0;
                    listOfBooks = new ArrayList<BookDetails>();

                }else {
                    listOfBooks.add(book);
                    currentCounter ++;
                }
            }
        } finally {
            LineIterator.closeQuietly(it);
        }

    }


}
