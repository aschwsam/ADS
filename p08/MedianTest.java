package p08;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author Stephan Graf
 * @since 03.05.17
 */
public class MedianTest {
    @Test
    public void shouldFindMedian(){
        int[] array=new int[5];
        array[0]=5;
        array[1]=4;
        array[2]=3;
        array[3]=2;
        array[4]=1;
        assertEquals(3,MedianQuickSort.median(array));
    }
}
