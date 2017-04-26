package p07;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class TestHashtable {

    @Before
    public void prep() {
    }


    @Test
    public void shouldNotAddValueAlreadyinit() {
        Hashtable<Integer> hashtable = new Hashtable<Integer>(10, true);
        hashtable.add(42);
        hashtable.add(42);
        Iterator<Integer> iterator = hashtable.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            if (iterator.next() == 42) {
                count++;
            }
            assertEquals(1, count);
        }
    }


    @Test
    public void checkCorrectSize() {
        Hashtable<Integer> hashtable = new Hashtable<Integer>(10, true);
        for (int i = 0; i < 8; i++) {
            hashtable.add(i);
        }
        int count = 0;
        Iterator iterator = hashtable.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        assertEquals(10, count);
        assertEquals(10, hashtable.size());
    }


    @Test
    public void checkIfTableIsEmpty() {
        Hashtable<Integer> hashtable = new Hashtable<Integer>(10, true);
        assertTrue(hashtable.isEmpty());
        hashtable.add(1);
        hashtable.remove(1);
        assertTrue(hashtable.isEmpty());
    }


    @Test
    public void checkAddElement() {
        Hashtable<Integer> hashtable = new Hashtable<Integer>(10, true);
        hashtable.add(1);
        assertTrue(hashtable.contains(1));
        assertFalse(hashtable.isEmpty());
    }


    @Test
    public void testExpansion() {
        Hashtable<Integer> hashtable = new Hashtable<Integer>(10, true);
        hashtable.add(0);
        assertTrue(hashtable.contains(0));
        for (int i = 1; i < 15; i++) {
            hashtable.add(i);
        }
        assertTrue(hashtable.size() > 10);
        assertFalse(hashtable.contains(0));
    }


    @Test
    public void checkRemoveElement() {
        Hashtable<Integer> hashtable = new Hashtable<Integer>(10, true);
        hashtable.add(41);
        hashtable.add(42);
        hashtable.add(43);
        hashtable.remove(42);
        assertFalse(hashtable.contains(42));
        assertFalse(hashtable.isEmpty());
        assertTrue(hashtable.contains(43));
        assertTrue(hashtable.contains(41));
        hashtable.remove(41);
        hashtable.remove(43);
        assertTrue(hashtable.isEmpty());
    }


    public void shouldRemoveEverythingWithIterator() {

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
