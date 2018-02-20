package com.mttask.trie;

import java.util.HashMap;

/**
 * Created by abhimanyus on 2/20/18.
 */
public class TrieNode {

    private HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    private String content;
    private boolean isWord;
    private int count = 0;
    private boolean endOfWord;

    public TrieNode() {
    }

    public TrieNode(String content) {
        this.content = content;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
