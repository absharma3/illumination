package com.mttask.trie.writer;

import com.mttask.trie.Trie;

import java.util.List;

/**
 * Created by abhimanyus on 2/28/18.
 */
public class TrieWriter implements  Runnable {

    private List<String> words = null;

    public TrieWriter(List<String> words) {
        this.words = words;
    }

    @Override
    public void run() {
        for(String word: words){
            Trie.INSTANCE.insert(word);
        }
    }
}
