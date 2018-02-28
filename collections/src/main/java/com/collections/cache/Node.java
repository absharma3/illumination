package com.collections.cache;

/**
 * Created by abhimanyus on 2/7/18.
 * Node class for LRU cache
 * this class acts as a node for doubly linked list
 *
 */
class Node{

    Integer value;
    Node previousNode;
    Node nextNode;

    public Node(Integer value){
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return value.equals(node.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
