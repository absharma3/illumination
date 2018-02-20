package com.mttask.trie;

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
        for (int i = 0; i < word.length(); i++) {
            current = current.getChildren().
                    computeIfAbsent(word.charAt(i),
                            c -> {
                                TrieNode node = new TrieNode();
                                node.setContent(Character.toString(c));
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

}
