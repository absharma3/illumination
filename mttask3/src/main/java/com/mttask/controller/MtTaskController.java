package com.mttask.controller;

import com.mttask.reader.FileReaderThreadMgr;
import com.mttask.trie.Trie;

import java.util.List;

/**
 * Created by abhimanyus on 2/20/18.
 */
public class MtTaskController {

    FileReaderThreadMgr threadMgr = new FileReaderThreadMgr();

    public List<String> autoComplete(String prefix){
        return Trie.INSTANCE.autoComplete(prefix);
    }


    public void readFiles(){
        threadMgr = new FileReaderThreadMgr();
        threadMgr.readFiles();
    }


}
