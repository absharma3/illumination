package com.mttask;

import com.mttask.constants.MtTaskConstants;
import com.mttask.helper.CSVHelper;



import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;

/**
 * Created by abhimanyus on 2/1/18.
 *
 * This is the main class responsible for starting the flow.
 * From here the flow passes through CSVHelper ->
 *
 */
public class MtTaskController {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CSVHelper reader = new CSVHelper(Integer.parseInt(MtTaskConstants.LINESTHRESHOLD.toString()));
        try {
            System.out.println(new SimpleDateFormat(MtTaskConstants.DATEFORMAT.toString()).format(new Timestamp(System.currentTimeMillis())));
            reader.readAndExecute(MtTaskConstants.READFILENAME.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
