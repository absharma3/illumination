package com.mttask.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by abhimanyus on 2/20/18.
 */
public class Trie {

    public static final Trie INSTANCE = new Trie();
    private TrieNode root;

    private Trie() {
        this.root = new TrieNode("");
    }

    public void insert(String word) {
        TrieNode current = root;
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            content.append(word.charAt(i));
            current = current.getChildren().
                    computeIfAbsent(word.charAt(i),
                            c -> {
                                TrieNode node = new TrieNode(content.toString());
                                return node;
                            });;
        }
        current.setCount(current.getCount()+1);
        current.setEndOfWord(true);
    }


    public boolean find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    public int getCount(String word){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return 0;
            }
            current = node;
        }
         if(current.isEndOfWord()){
             return current.getCount();
        } else{
             return 0;
         }
    }

    public List<String> autoComplete(String prefix){
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!current.getChildren().containsKey(ch)) {
                return Collections.emptyList();
            }
            current = current.getChildren().get(ch);
        }
        return allPrefixes(current);
    }

    private List<String> allPrefixes(TrieNode current) {

        List<String> allWords = new ArrayList<String>();
        if (current.isEndOfWord()) {
            allWords.add(current.getContent());
        }
        for (Map.Entry<Character, TrieNode> entry : current.getChildren().entrySet()) {
            TrieNode child = entry.getValue();
            List<String> childPrefixes = allPrefixes(child);
            allWords.addAll(childPrefixes);
        }
        return allWords;
    }


}
