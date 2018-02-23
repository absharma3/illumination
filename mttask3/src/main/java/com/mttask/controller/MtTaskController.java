package com.mttask.controller;

import com.mttask.reader.FileReaderThreadMgr;
import com.mttask.trie.Trie;

import java.util.List;

/**
 * Created by abhimanyus on 2/20/18.
 */
public class MtTaskController {

    FileReaderThreadMgr threadMgr = null;


    public MtTaskController() {
        threadMgr = new FileReaderThreadMgr();
        threadMgr.readFiles();
    }

    public List<String> autoComplete(String prefix){

        return Trie.INSTANCE.autoComplete(prefix);
    }


    public static void main(String [] args){
        MtTaskController controller = new MtTaskController();
        List<String> words = controller.autoComplete("th");
        for(String word : words){
            System.out.println(word);
        }
    }


}
