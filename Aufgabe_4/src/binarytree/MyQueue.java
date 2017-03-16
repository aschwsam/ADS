package binarytree;


import java.util.LinkedList;


/**
 * Created by stephan on 15.03.17.
 */

public class MyQueue {
    LinkedList list;


    public MyQueue() {
        list = new LinkedList();
    }


    public void add(Object object) {
        list.addLast(object);
    }


    public Object remove() {
        Object node = list.getFirst();
        list.removeFirst();
        return node;
    }


    public boolean isEmpty() {
        return list.isEmpty();
    }
}
