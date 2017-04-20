package p07;


import java.util.Iterator;


public class Hashtable<T> implements Iterable<T> {

    Placeholder PLACEHOLDER=new Placeholder();
    private int tablesize;
    private boolean lineareprobe;
    private Object[] table;

    private static final int PRIME = 839;


    /**
     * TODO: Complete constructor description
     *
     * @param size  (initial table-size)
     * @param probe (true = linear, false = quadratic)
     */
    public Hashtable(Integer size, boolean probe) {
        tablesize = size;
        lineareprobe = probe;
        table = (T[])new Object[size];
    }


    public void add(T value) {

        if (!contains(value)) {
            int bucket = hash(value, 0);
            while (!isFree(bucket)) {
                bucket = nextBucket(bucket);
            }
            table[bucket] = value;
        }
    }

    private T get(int bucket){
        if (table[bucket]==PLACEHOLDER){ return null;}
        else{return (T)table[bucket];}
    }


    public Boolean isFree(int bucket) {
        return table[bucket] == PLACEHOLDER || table[bucket]==null;
    }


    public Boolean isFresh(int bucket) {
        return table[bucket] == null;
    }


    public int nextBucket(int current) {
        if (lineareprobe) {
            return current+1%tablesize;
        } else {
            return (current + 1) ^ 2;}
    }


    public int hash(T value, int seed) {
        return ((System.identityHashCode(value) + seed) % PRIME) % size();
    }


    /**
     * Return the size of the hashtable
     *
     * @return int
     */
    public int size() {
        return table.length;
    }


    /**
     * Return true if hashtable is empty
     * otherwise false
     *
     * @return boolean
     */
    public boolean isEmpty() {
        for (int i = 0; i < size(); i++) {
            if (table[i] != null) {
                return false;
            }
        }
        return true;
    }


    /**
     * Iterates over hashtable and searches for a given value
     *
     * @param needle
     *
     * @return boolean
     */
    public boolean contains(T needle) {

        int i = 0;
        int bucket = hash(needle, i);

        // is not null, is not placeholder cannot be needle (break)
        while (!isFresh(bucket)) {
            if(table[bucket] == needle){
                return true;
            } else {
                bucket=nextBucket(bucket);
            }
        }
        return false;
    }


    /**
     * Custom iterator for hashtable
     *
     * @return iterator
     */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int iterator_position = -1;

            @Override
            public boolean hasNext() {
                return (iterator_position + 1 < tablesize);
            }

            @Override
            public T next()
            {
                if(!table[++iterator_position].equals(PLACEHOLDER)){
                    return (T)table[++iterator_position];
                }else{
                    return null;
                }
            }

            @Override
            public void remove() {
                table[iterator_position] = PLACEHOLDER;
            }
        };

        return it;
    }
}
