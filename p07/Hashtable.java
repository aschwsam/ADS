package p07;

import java.util.Iterator;


public class Hashtable <T> implements Iterable<T>{

    private int tablesize;
    private boolean lineareprobe;
    private T[] table;
    private static final int PRIME = 839;

    /**
     * TODO: Complete constructor description
     *
     * @param size (initial table-size)
     * @param probe (true = linear, false = quadratic)
     */
    public Hashtable (Integer size, boolean probe){

        tablesize = size;
        lineareprobe = probe;
        table = (T[]) new Object[size];
    }

    // TODO: Remove this dummy method
    public void test(){
        // Add value to array
        /*
        table[0] = new HashTableElement("XXX world");
        table[1] = new HashTableElement("hello world");
        table[2] = new HashTableElement(5);
        table[3] = new HashTableElement((float)7.98768476582);
        table[4] = new HashTableElement(15);
        table[5] = new HashTableElement(false);
        table[6] = new HashTableElement('a');
        */
    }

    public void add(T value){
        int bucket = hash(value,0);

        if(table[bucket]==null){
            table[bucket] = value;
        } else {
            int i = 0;
            while (table[bucket] != null){
                bucket=nextFree(bucket);
                if (lineareprobe) {
                    i++;
                    bucket = hash(value, i);
                } else {
                    // TODO: Quadratic probing
                }
            }

            table[bucket] = value;
        }
    }

    public int hash(T value, int seed){
        return ((System.identityHashCode(value)+seed)%PRIME)%size();
    }


    /**
     * Return the size of the hashtable
     *
     * @return int
     */
    public int size(){
        return table.length;
    }

    /**
     * Return true if hashtable is empty
     * otherwise false
     *
     * @return boolean
     */
    public boolean isEmpty(){
        for(int i=0;i<size();i++){
            if(table[i]!=null){
                return false;
            }
        }
        return true;
    }

    /**
     * Iterates over hashtable and searches for a given value
     * @param needle
     * @return boolean
     */
    public boolean contains(T needle){

        int i=0;
        int bucket = hash(needle, i);

        while (table[bucket] != null){

            if (lineareprobe) {
                bucket = hash(needle, i);
                i++;
            } else {
                // TODO: Quadratic probing
            }
            return table[bucket]==needle;
        }
        return false;
    }

    /**
     * Custom iterator for hashtable
     *
     * @return iterator
     */
    @Override
    public Iterator<T> iterator(){
        Iterator<T> it = new Iterator<T>(){

            private int iterator_position = -1;

            @Override
            public boolean hasNext(){
                return(iterator_position+1<tablesize);
            }

            @Override
            public T next(){
                return table[++iterator_position];
            }

            @Override
            public void remove(){
                // Go one step back
                table[iterator_position]=null;
            }
        };

        return it;
    }
}
