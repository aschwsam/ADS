package p07;

import java.util.Iterator;


public class Hashtable<T> implements Iterable<T> {

    Placeholder PLACEHOLDER=new Placeholder();
    private int tablesize;
    private boolean lineareprobe;
    private Object[] table;
    private int itemcount = 0;
    private static int loadfactor = 70;

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

        itemcount++;

        // Check if more buckets are needed
        if(Math.floor((itemcount*100)/size())>loadfactor){
            Object[] newtable = (T[])new Object[tablesize+1000];

            Iterator<T> it = this.iterator();
            while(it.hasNext()){
                T tmpvalue = it.next();
                int bucket = hash(tmpvalue);
                while(!isFree(bucket)){
                    bucket = nextBucket(bucket);
                }
                newtable[bucket] = tmpvalue;
            }

            tablesize+=1000;
            itemcount=1;    // Accounting for the new element
            table = newtable;
        }

        if (!contains(value)) {
            int bucket = hash(value);
            while (!isFree(bucket)) {
                bucket = nextBucket(bucket);
            }
            table[bucket] = value;
        }

    }

    /**
     * Set the limit of used buckets in % before adding more buckets
     * @param loadlimit
     */
    public void setLoadFactorForResize(int loadlimit){
        loadfactor = loadlimit;
    }

    public int getLoadfactorForResize(){
        return loadfactor;
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


    public int hash(T value) {
        return ((System.identityHashCode(value)) % PRIME) % size();
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
        int bucket = hash(needle);

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
            public void remove() {
                table[iterator_position] = PLACEHOLDER;
            }
        };

        return it;
    }
}
