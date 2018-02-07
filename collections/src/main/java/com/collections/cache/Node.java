package com.collections.cache;

/**
 * Created by abhimanyus on 2/7/18.
 * Node class for LRU cache
 * this class acts as a node for doubly linked list
 *
 */
class Node{
    int key;
    int value;
    Node previousNode;
    Node nextNode;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
