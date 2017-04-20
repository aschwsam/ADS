package p07;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;


public class TestHashtable {

    @Before
    public void prep() {
    }


    @Test
    public void checkCorrectSize() {
        Hashtable<Integer> hashtable = new Hashtable<Integer>(10, true);
        for (int i = 0; i < 10; i++) {
            hashtable.add(i);
        }
        int count=0;
        Iterator iterator = hashtable.iterator();
        while(iterator.hasNext()){
            iterator.next();
            count++;
        }
        assertEquals(10,count);
        assertEquals(10,hashtable.size());
    }


    @Test
    public void checkIfTableIsEmpty() {

    }


    @Test
    public void checkAddElement() {

    }


    @Test
    public void checkRemoveElement() {


    }


    @Test
    public void checkContainsElementPositive() {

    }


    @Test
    public void checkContainsElementNegative() {

    }


    @Test
    public void checkSearchLinear() {

    }


    @Test
    public void checkSearchSquare() {

    }


    @Test
    public void checkIterator() {

    }


    @After
    public void close() {
        // cleanup
    }
}
