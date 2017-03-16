package binarytree;
import java.util.LinkedList;

/**
 * @author Stephan Graf
 * @version 15.03.17.
 */

public class MyQueue<E extends Object> {
    LinkedList<E> list;


    public MyQueue() {
        list = new LinkedList();
    }


    public void add(E element) {
        list.addLast(element);
    }


    public E remove() {
        E element = list.getFirst();
        list.removeFirst();
        return element;
    }


    public boolean isEmpty() {
        return list.isEmpty();
    }
}
