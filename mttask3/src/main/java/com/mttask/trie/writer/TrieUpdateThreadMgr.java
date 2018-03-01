package com.mttask.trie.writer;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by abhimanyus on 2/28/18.
 */
public class TrieUpdateThreadMgr {

    private static BlockingQueue<List<String>> queue = new LinkedBlockingQueue<List<String>>();
    private ExecutorService executor = Executors.newCachedThreadPool();

    public void addWords(List<String> words){
        queue.add(words);
    }

    public void spawnThreadsToUpdateTrie(){
        //Have to think a logic to update trie without running an infinite loop
        while(true) {
            try {
                TrieWriter trieWriter = new TrieWriter(queue.take());
                executor.submit(trieWriter);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
