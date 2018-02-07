package com.collections.cache;

import java.util.HashMap;

/**
 * Created by abhimanyus on 2/7/18.
 *
 * LRUCache mainly maintained using a doubly linked list and a hashmap
 */

public class LRUCache {
    int size;
    HashMap<Integer, Node> keysAndValues = new HashMap<Integer, Node>();
    Node headPointer =null;
    Node tailPointer =null;

    public LRUCache(int size) {
        this.size = size;
    }

    public int get(int key) {
        if(keysAndValues.containsKey(key)){
            Node n = keysAndValues.get(key);
            remove(n);
            setHeadPointer(n);
            return n.value;
        }

        return -1;
    }

    public void remove(Node n){
        if(n.previousNode !=null){
            n.previousNode.nextNode = n.nextNode;
        }else{
            headPointer = n.nextNode;
        }

        if(n.nextNode !=null){
            n.nextNode.previousNode = n.previousNode;
        }else{
            tailPointer = n.previousNode;
        }

    }

    public void setHeadPointer(Node n){
        n.nextNode = headPointer;
        n.previousNode = null;

        if(headPointer !=null)
            headPointer.previousNode = n;

        headPointer = n;

        if(tailPointer ==null)
            tailPointer = headPointer;
    }

    public void set(int key, int value) {
        if(keysAndValues.containsKey(key)){
            Node old = keysAndValues.get(key);
            old.value = value;
            remove(old);
            setHeadPointer(old);
        }else{
            Node created = new Node(key, value);
            if(keysAndValues.size()>= size){
                keysAndValues.remove(tailPointer.key);
                remove(tailPointer);
                setHeadPointer(created);

            }else{
                setHeadPointer(created);
            }

            keysAndValues.put(key, created);
        }
    }
}