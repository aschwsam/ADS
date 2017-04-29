package p08;


import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * @author Stephan Graf
 * @since 28.04.17
 * Test the sorting of an array of integers
 * This Test does currently not check for empty arrays and fields and other "wrong" inputs.
 * todo: maybe check for empty and invalid arrays
 * writing many test cases it gets more and more difficult to recognize if they are actually new test cases
 */
public class QuickSort3Test {
    private final SortingAlgorithm myQuicksort2;


    /*
        even/uneven
        sorted/unsorted
        duplicate numbers/
        multiple duplicates
        negative values
        with zero in it
        try    to trick  pivot thing pivot is a duplicate, under upper under upper, pivot is lowest
        ein test der testen soll, dass sich nichts ändert aber eigenntlich gar nichts testet?
    */
    public QuickSort3Test() {
        myQuicksort2 = new Quicksort2();
    }

   /*---------------------------------------------------------- SORT -------------------------------------------------*/
    /*These Arrays are already sorted and therefore nothing should be done */


    @Test
    public void shouldSortRandomArrayWithEvenLength() {
        int[] array = new int[6];
        array[0] = 3;
        array[1] = 4;
        array[2] = 5;
        array[3] = 6;
        array[4] = 7;
        array[5] = 8;
        Quicksort2.sort(array);
    }


    /**
     * :
     * :
     * :_ _ _ _ _ --> _ _ _ _ _
     */
    @Test
    public void shouldNotChangeArrayWithAllZeros() {
        int[] array = new int[6];
        array[0] = 0;
        array[1] = 0;
        array[2] = 0;
        array[3] = 0;
        array[4] = 0;
        array[5] = 0;
        Quicksort2.sort(array);
        assertEquals(6, array.length);
        assertEquals(0, array[0]);
        assertEquals(0, array[1]);
        assertEquals(0, array[2]);
        assertEquals(0, array[3]);
        assertEquals(0, array[4]);
        assertEquals(0, array[5]);
    }


    /**
     * :
     * :
     * :
     */
    @Test
    public void shouldSortDescendingArrayWithEvenLength() {
        int[] array = new int[6];
        array[0] = 8;
        array[1] = 7;
        array[2] = 6;
        array[3] = 5;
        array[4] = 4;
        array[5] = 3;
        Quicksort2.sort(array);
        assertEquals(6, array.length);
        assertEquals(3, array[0]);
        assertEquals(4, array[1]);
        assertEquals(5, array[2]);
        assertEquals(6, array[3]);
        assertEquals(7, array[4]);
        assertEquals(8, array[5]);
    }


    @Test
    public void shouldSortDescendingArrayWithOddLength() {
        int[] array = new int[7];
        array[0] = 8;
        array[1] = 7;
        array[2] = 6;
        array[3] = 5;
        array[4] = 4;
        array[5] = 3;
        array[6] = 2;
        Quicksort2.sort(array);
        assertEquals(7, array.length);
        assertEquals(2, array[0]);
        assertEquals(3, array[1]);
        assertEquals(4, array[2]);
        assertEquals(5, array[3]);
        assertEquals(6, array[4]);
        assertEquals(7, array[5]);
        assertEquals(8, array[6]);
    }


    /**
     *
     */
    @Test
    public void shouldSortDescendingArrayWithEvenLengthWithOneDuplicate() {
        int[] array = new int[6];
        array[0] = 8;
        array[1] = 7;
        array[2] = 6;
        array[3] = 4;
        array[4] = 4;
        array[5] = 3;
        Quicksort2.sort(array);
        assertEquals(6, array.length);
        assertEquals(3, array[0]);
        assertEquals(4, array[1]);
        assertEquals(4, array[2]);
        assertEquals(6, array[3]);
        assertEquals(7, array[4]);
        assertEquals(8, array[5]);
    }


    /**
     *
     */
    @Test
    public void shouldSortDescendingArrayWithEvenLengthWithMultipleDuplicate() {
        int[] array = new int[6];
        array[0] = 8;
        array[1] = 8;
        array[2] = 6;
        array[3] = 4;
        array[4] = 4;
        array[5] = 3;
        Quicksort2.sort(array);
        assertEquals(6, array.length);
        assertEquals(3, array[0]);
        assertEquals(4, array[1]);
        assertEquals(4, array[2]);
        assertEquals(6, array[3]);
        assertEquals(8, array[4]);
        assertEquals(8, array[5]);
    }


    @Test
    public void shouldSortDescendingArrayWithOddLengthWithOneDuplicate() {
        int[] array = new int[7];
        array[0] = 8;
        array[1] = 7;
        array[2] = 6;
        array[3] = 6;
        array[4] = 4;
        array[5] = 3;
        array[6] = 2;
        Quicksort2.sort(array);
        assertEquals(7, array.length);
        assertEquals(2, array[0]);
        assertEquals(3, array[1]);
        assertEquals(4, array[2]);
        assertEquals(6, array[3]);
        assertEquals(6, array[4]);
        assertEquals(7, array[5]);
        assertEquals(8, array[6]);
    }


    @Test
    public void shouldSortRandomArrayWithEvenLengthWithOneDuplicate() {
        int[] array = new int[6];
        array[0] = 6;
        array[1] = 6;
        array[2] = 4;
        array[3] = 2;
        array[4] = 5;
        array[5] = 1;
        Quicksort2.sort(array);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(4, array[2]);
        assertEquals(5, array[3]);
        assertEquals(6, array[4]);
        assertEquals(6, array[5]);
    }


    @Test
    public void shouldSortRandomArrayWithEvenLengthWithZeros() {
        int[] array = new int[6];
        array[0] = 6;
        array[1] = 0;
        array[2] = 4;
        array[3] = 2;
        array[4] = 5;
        array[5] = 1;
        Quicksort2.sort(array);
        assertEquals(0, array[0]);
        assertEquals(1, array[1]);
        assertEquals(2, array[2]);
        assertEquals(4, array[3]);
        assertEquals(5, array[4]);
        assertEquals(6, array[5]);
    }


    @Test
    public void shouldSortAlmostDescendingArrayWithEvenLengthWithLowestOnTop() {
        int[] array = new int[6];
        array[0] = 2;
        array[1] = 3;
        array[2] = 4;
        array[3] = 5;
        array[4] = 6;
        array[5] = 1;
        Quicksort2.sort(array);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
        assertEquals(4, array[3]);
        assertEquals(5, array[4]);
        assertEquals(6, array[5]);
    }


    /**
     * █         █
     * █   -->   █
     * █ _     _ █
     */
    @Test
    public void shouldSortTwoElementArray() {
        int[] array = new int[2];
        array[0] = 1;
        array[1] = 0;
        Quicksort2.sort(array);
        assertEquals(0, array[0]);
        assertEquals(1, array[1]);
    }


    /*------------------------------------------------------ DO NOTHING  ---------------------------------------------*/
    /*These Arrays are already sorted and therefore nothing should be done */


    /**
     * :
     * :   -->
     * :
     */

    @Test
    public void shoulNotChangeArrayWithZeroLength() {
        int[] array = new int[0];
        Quicksort2.sort(array);
        assertEquals(0, array.length);
    }


    /**
     * :
     * : _ _ _ _ _   --> _ _ _ _ _
     * :
     */
    @Test
    public void shoulNotChangeEmptyArray() {
        int[] array = new int[5];
        Quicksort2.sort(array);
        assertEquals(5, array.length);
        assertEquals(0, array[0]);
        assertEquals(0, array[1]);
        assertEquals(0, array[2]);
        assertEquals(0, array[3]);
        assertEquals(0, array[4]);
    }


    /**
     * █ █ █ █ █ █     █ █ █ █ █ █
     * █ █ █ █ █ █ --> █ █ █ █ █ █
     * █ █ █ █ █ █     █ █ █ █ █ █
     */
    @Test
    public void shouldNotChangeArrayWithSameNumbers() {
        int[] array = new int[6];
        array[0] = 42;
        array[1] = 42;
        array[2] = 42;
        array[3] = 42;
        array[4] = 42;
        array[5] = 42;
        Quicksort2.sort(array);
        assertEquals(6, array.length);
        assertEquals(42, array[0]);
        assertEquals(42, array[1]);
        assertEquals(42, array[2]);
        assertEquals(42, array[3]);
        assertEquals(42, array[4]);
        assertEquals(42, array[5]);
    }


    /**
     * ▄ █               ▄ █
     * ▄ █ █ █  -->      ▄ █ █ █
     * ▄ █ █ █ █ █       ▄ █ █ █ █ █
     */
    @Test
    public void shouldNotChangeAlreadySortedArrayWithEvenLength() {
        int[] array = new int[6];
        array[0] = 3;
        array[1] = 4;
        array[2] = 5;
        array[3] = 6;
        array[4] = 7;
        array[5] = 8;
        Quicksort2.sort(array);
        assertEquals(3, array[0]);
        assertEquals(4, array[1]);
        assertEquals(5, array[2]);
        assertEquals(6, array[3]);
        assertEquals(7, array[4]);
        assertEquals(8, array[5]);
    }


    /**
     * ▄                 ▄
     * ▄ █ █  -->        ▄ █ █
     * ▄ █ █ █ █ █       ▄ █ █ █ █ █
     */
    @Test
    public void shouldNotChangeAlreadySortedArrayWithEvenLengthWithDuplicates() {
        int[] array = new int[6];
        array[0] = 3;
        array[1] = 4;
        array[2] = 4;
        array[3] = 6;
        array[4] = 7;
        array[5] = 8;
        Quicksort2.sort(array);
        assertEquals(3, array[0]);
        assertEquals(4, array[1]);
        assertEquals(4, array[2]);
        assertEquals(6, array[3]);
        assertEquals(7, array[4]);
        assertEquals(8, array[5]);
    }


    /**
     * :      ▄ █            ▄ █
     * :   ▄ █ █ █  -->   ▄ █ █ █
     * :  █ █ █ █ █      █ █ █ █ █
     */
    @Test
    public void shouldNotChangeAlreadySortedArrayWithOddLength() {
        int[] array = new int[5];
        array[0] = 2;
        array[1] = 3;
        array[2] = 4;
        array[3] = 5;
        array[4] = 6;
        Quicksort2.sort(array);
        assertEquals(2, array[0]);
        assertEquals(3, array[1]);
        assertEquals(4, array[2]);
        assertEquals(5, array[3]);
        assertEquals(6, array[4]);
    }


    /**
     * ▄ █  -->        ▄ █
     * ▄ █ █ █ █       ▄ █ █ █ █
     */
    @Test
    public void shouldNotChangeAlreadySortedArrayWithOddLengthWithDuplicates() {
        int[] array = new int[5];
        array[0] = 3;
        array[1] = 4;
        array[2] = 4;
        array[3] = 6;
        array[4] = 7;
        Quicksort2.sort(array);
        assertEquals(3, array[0]);
        assertEquals(4, array[1]);
        assertEquals(4, array[2]);
        assertEquals(6, array[3]);
        assertEquals(7, array[4]);
    }


    /**
     * : █ █      █ █
     * : █ █  --> █ █
     * : █ █      █ █
     */
    @Test
    public void shouldNotChangeTwoElementArrayWithDuplicates() {
        int[] array = new int[2];
        array[0] = 0;
        array[1] = 0;
        Quicksort2.sort(array);
        assertEquals(0, array[0]);
        assertEquals(0, array[1]);
    }


    /**
     * █      █
     * █ ---> █
     * █      █
     */
    @Test
    public void shouldNotChangeOneElementArray() {
        int[] array = new int[1];
        array[0] = 42;
        Quicksort2.sort(array);
        assertEquals(42, array[0]);
        assertEquals(1, array.length);
    }


    /*------------------------------------------------------- MINIMAL ------------------------------------------------*/
    /*Some tests that pass if something no matter how small is done in the right direction*/


    /**
     * █              █
     * █ ▄ █     -x-> █ ▄ █
     * █ █ █ █ ▄      █ █ █ █ ▄
     */
    @Test
    public void shouldDoAtLeastSomething() {
        int[] array = new int[5];
        array[0] = 8;
        array[1] = 4;
        array[2] = 5;
        array[3] = 3;
        array[4] = 1;
        int[] old = new int[5];
        System.arraycopy(array, 0, old, 0, 5);
        Quicksort2.sort(array);
        int changes = 0;
        for (int i = 0; i < 5; i++) {

            if (old[i] != array[i])
                changes++;
        }
        assertTrue(changes > 0);
    }


    /**
     * █             █
     * █ ▄ █     --> █ ▄ █
     * █ █ █ █ ▄     █ █ █ █ ▄
     * int[5]    --> int[5]
     * Doesn't have to be sorted but doesn't lose or add an element
     */
    @Test
    public void arrayShouldNotChangeSizeBySorting() {
        int[] array = new int[5];
        array[0] = 8;
        array[1] = 4;
        array[2] = 5;
        array[3] = 3;
        array[4] = 1;
        Quicksort2.sort(array);
        assertEquals(5, array.length);
    }


    /**
     * █             █   x x
     * █ ▄ █     --> █ ▄   █
     * █ █ █ █ ▄     █ █ █ █ ▄
     * 8 4 5 3 1     8 4 3 5 1
     * Doesn't have to be sorted but the numbers are the same
     */
    @Test
    public void shouldContainSameNumbers() {
        int[] array = new int[5];
        array[0] = 8;
        array[1] = 4;
        array[2] = 5;
        array[3] = 3;
        array[4] = 1;
        int[] old = new int[5];
        System.arraycopy(array, 0, old, 0, 5);
        Quicksort2.sort(array);
        for (int i = 0; i < 5; i++) {
            if (old[i] == array[i]) {
                assertTrue(Arrays.asList(array).contains(i));
            }
        }
    }


    /**
     * █               █
     * █ ▄ █     --> ! █ ▄   █
     * █ █ █ █ ▄     ▄ █ █ █ █
     * 8 4 5 3 1     1 8 4 3 5
     */
    @Test
    public void smallestShouldBeFirst() {
        int[] array = new int[5];
        array[0] = 8;
        array[1] = 4;
        array[2] = 5;
        array[3] = 3;
        array[4] = 1;
        Quicksort2.sort(array);
        assertEquals(1, array[0]);
    }


    /**
     * █                █
     * █ ▄ █     -X-> █ █ ▄   !
     * █ █ █ ▄ █      █ █ █ █ ▄
     * 8 4 5 1 3      * * * * 1
     */
    @Test
    public void smallestShouldNotBeLast() {
        int[] array = new int[5];
        array[0] = 8;
        array[1] = 4;
        array[2] = 5;
        array[3] = 1;
        array[4] = 3;
        Quicksort2.sort(array);
        assertNotEquals(1, array[4]);
    }


    @Test
    public void largestShouldBeLast() {
        int[] array = new int[5];
        array[0] = 6;
        array[1] = 4;
        array[2] = 5;
        array[3] = 3;
        array[4] = 1;
        Quicksort2.sort(array);
        assertEquals(6, array[4]);
    }


    @Test
    public void largestShouldNotBeFirst() {
        int[] array = new int[5];
        array[0] = 4;
        array[1] = 6;
        array[2] = 5;
        array[3] = 1;
        array[4] = 3;
        Quicksort2.sort(array);
        assertNotEquals(6, array[0]);
    }


    /*------------------------------------------------------- ADVANCED
    ------------------------------------------------*/
    /*This Tests are designed to try to trick the Algorithm*/


    /**
     * █ █ █ █         █ █ █ █
     * █ █ █ █   -->   █ █ █ █
     * █ █ █ █ ▄     ▄ █ █ █ █
     */
    @Test
    public void ShouldSortSpecialCase1() {
        int[] array = new int[5];
        array[0] = 42;
        array[1] = 42;
        array[2] = 42;
        array[3] = 42;
        array[4] = 1;
        Quicksort2.sort(array);
        assertNotEquals(42, array[0]);
        assertEquals(1, array[0]);
        assertEquals(42, array[1]);
        assertEquals(42, array[2]);
        assertEquals(42, array[3]);
        assertEquals(42, array[4]);
    }


    /**
     * :    █             █
     * :▄ ▄ █ ▄ ▄ --> ▄ ▄ █ ▄ ▄
     * :█ █ █ █ █     █ █ █ █ █
     */
    @Test
    public void ShouldSortSpecialCase2() {
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;
        array[3] = 1;
        array[4] = 1;
        Quicksort2.sort(array);
        assertEquals(1, array[0]);
        assertEquals(1, array[1]);
        assertEquals(1, array[2]);
        assertEquals(1, array[3]);
        assertEquals(2, array[4]);
    }


    /**
     * :   █ █ █           █ █ █
     * : ▄ █ █ █ ▄ --> ▄ ▄ █ █ █
     * : █ █ █ █ █     █ █ █ █ █
     */
    @Test
    public void ShouldSortArrayWithDuplicatePivot() {
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 2;
        array[3] = 2;
        array[4] = 1;
        Quicksort2.sort(array);
        assertEquals(1, array[0]);
        assertEquals(1, array[1]);
        assertEquals(2, array[2]);
        assertEquals(2, array[3]);
        assertEquals(2, array[4]);
    }


    /**
     * :     ▄   █           ▄ █
     * :   ▄ █   █ -->     ▄ █ █
     * : █ █ █ ▄ █     ▄ █ █ █ █
     */
    @Test
    public void shouldSortConsistentArrayWithOneException() {
        int[] array = new int[5];
        array[0] = 2;
        array[1] = 3;
        array[2] = 5;
        array[3] = 1;
        array[4] = 6;
        Quicksort2.sort(array);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
        assertEquals(5, array[3]);
        assertEquals(6, array[4]);
    }


    /**
     * If this Test is Red and all the other Tests are green then you just fund an unchecked testcase--> add it
     */
    @Test
    public void bruteForce() {
        int length;
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            length = random.nextInt(60);
            int[] array = new int[length];
            int[] reference = new int[length];
            for (int j = 0; j < length; j++) {
                array[j] = random.nextInt(21) - 10;
            }
            //copy
            System.arraycopy(array, 0, reference, 0, length);
            Quicksort2.sort(array);
            /*
            System.out.println("unsorted:" + Arrays.toString(reference));
            System.out.println("sorted  :" + Arrays.toString(array));
            */
            Arrays.sort(reference);
            //System.out.println("expected:" + Arrays.toString(reference));

            for (int j = 0; j < length; j++) {
                assertEquals(reference[j], array[j]);
            }
        }
    }
}