package p08;


import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * @author Stephan Graf (https://github.com/grafst)
 * @since 28.04.17
 * Test the sorting of an array of integers
 * This Test does currently not check for empty arrays and fields and other "wrong" inputs.
 */
public class AlgorithmTest {
    private static final int TIMEOUT = 1000;
    private static final SortingAlgorithm algorithm = new QuickSortTurbo();

   /*---------------------------------------------------- SORT -----------------------------------------------------*/
    /*These are different unsorted Arrays who should be sorted. */


    @Test(timeout = TIMEOUT)
    public void shouldSortRandomArrayWithEvenLength() {
        int[] array = new int[6];
        array[0] = 3;
        array[1] = 4;
        array[2] = 5;
        array[3] = 6;
        array[4] = 7;
        array[5] = 8;
        algorithm.sort(array);
        //todo: add test
    }


    /**
     * :
     * :
     * :
     */
    @Test(timeout = TIMEOUT)
    public void shouldSortDescendingArrayWithEvenLength() {
        int[] array = new int[6];
        array[0] = 8;
        array[1] = 7;
        array[2] = 6;
        array[3] = 5;
        array[4] = 4;
        array[5] = 3;
        algorithm.sort(array);
        assertEquals(6, array.length);
        assertEquals(3, array[0]);
        assertEquals(4, array[1]);
        assertEquals(5, array[2]);
        assertEquals(6, array[3]);
        assertEquals(7, array[4]);
        assertEquals(8, array[5]);
    }


    @Test(timeout = TIMEOUT)
    public void shouldSortDescendingArrayWithOddLength() {
        int[] array = new int[7];
        array[0] = 8;
        array[1] = 7;
        array[2] = 6;
        array[3] = 5;
        array[4] = 4;
        array[5] = 3;
        array[6] = 2;
        algorithm.sort(array);
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
    @Test(timeout = TIMEOUT)
    public void shouldSortDescendingArrayWithEvenLengthWithOneDuplicate() {
        int[] array = new int[6];
        array[0] = 8;
        array[1] = 7;
        array[2] = 6;
        array[3] = 4;
        array[4] = 4;
        array[5] = 3;
        algorithm.sort(array);
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
    @Test(timeout = TIMEOUT)
    public void shouldSortDescendingArrayWithEvenLengthWithMultipleDuplicates() {
        int[] array = new int[6];
        array[0] = 8;
        array[1] = 8;
        array[2] = 6;
        array[3] = 4;
        array[4] = 4;
        array[5] = 3;
        algorithm.sort(array);
        assertEquals(6, array.length);
        assertEquals(3, array[0]);
        assertEquals(4, array[1]);
        assertEquals(4, array[2]);
        assertEquals(6, array[3]);
        assertEquals(8, array[4]);
        assertEquals(8, array[5]);
    }


    @Test(timeout = TIMEOUT)
    public void shouldSortDescendingArrayWithOddLengthWithOneDuplicate() {
        int[] array = new int[7];
        array[0] = 8;
        array[1] = 7;
        array[2] = 6;
        array[3] = 6;
        array[4] = 4;
        array[5] = 3;
        array[6] = 2;
        algorithm.sort(array);
        assertEquals(7, array.length);
        assertEquals(2, array[0]);
        assertEquals(3, array[1]);
        assertEquals(4, array[2]);
        assertEquals(6, array[3]);
        assertEquals(6, array[4]);
        assertEquals(7, array[5]);
        assertEquals(8, array[6]);
    }


    @Test(timeout = TIMEOUT)
    public void shouldSortRandomArrayWithEvenLengthWithOneDuplicate() {
        int[] array = new int[6];
        array[0] = 6;
        array[1] = 6;
        array[2] = 4;
        array[3] = 2;
        array[4] = 5;
        array[5] = 1;
        algorithm.sort(array);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(4, array[2]);
        assertEquals(5, array[3]);
        assertEquals(6, array[4]);
        assertEquals(6, array[5]);
    }


    @Test(timeout = TIMEOUT)
    public void shouldSortRandomArrayWithEvenLengthWithZeros() {
        int[] array = new int[6];
        array[0] = 6;
        array[1] = 0;
        array[2] = 4;
        array[3] = 2;
        array[4] = 5;
        array[5] = 1;
        algorithm.sort(array);
        assertEquals(0, array[0]);
        assertEquals(1, array[1]);
        assertEquals(2, array[2]);
        assertEquals(4, array[3]);
        assertEquals(5, array[4]);
        assertEquals(6, array[5]);
    }


    @Test(timeout = TIMEOUT)
    public void shouldSortAlmostDescendingArrayWithEvenLengthWithLowestOnTop() {
        int[] array = new int[6];
        array[0] = 2;
        array[1] = 3;
        array[2] = 4;
        array[3] = 5;
        array[4] = 6;
        array[5] = 1;
        algorithm.sort(array);
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
    @Test(timeout = TIMEOUT)
    public void shouldSortTwoElementArray() {
        int[] array = new int[2];
        array[0] = 1;
        array[1] = 0;
        algorithm.sort(array);
        assertEquals(0, array[0]);
        assertEquals(1, array[1]);
    }


    /*------------------------------------------------------ DO NOTHING  ---------------------------------------------*/
    /*These Arrays are already sorted and therefore nothing should be done */


    /**
     * :
     * : _ _ _ _ _   --> _ _ _ _ _
     * :
     */
    @Test(timeout = TIMEOUT)
    public void shouldNotChangeEmptyArray() {
        int[] array = new int[5];
        algorithm.sort(array);
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
    @Test(timeout = TIMEOUT)
    public void shouldNotChangeArrayWithSameNumbers() {
        int[] array = new int[6];
        array[0] = 42;
        array[1] = 42;
        array[2] = 42;
        array[3] = 42;
        array[4] = 42;
        array[5] = 42;
        algorithm.sort(array);
        assertEquals(6, array.length);
        assertEquals(42, array[0]);
        assertEquals(42, array[1]);
        assertEquals(42, array[2]);
        assertEquals(42, array[3]);
        assertEquals(42, array[4]);
        assertEquals(42, array[5]);
    }


    /**
     * :
     * :
     * :_ _ _ _ _ --> _ _ _ _ _
     */
    @Test(timeout = TIMEOUT)
    public void shouldNotChangeArrayWithAllZeros() {
        int[] array = new int[6];
        array[0] = 0;
        array[1] = 0;
        array[2] = 0;
        array[3] = 0;
        array[4] = 0;
        array[5] = 0;
        algorithm.sort(array);
        assertEquals(6, array.length);
        assertEquals(0, array[0]);
        assertEquals(0, array[1]);
        assertEquals(0, array[2]);
        assertEquals(0, array[3]);
        assertEquals(0, array[4]);
        assertEquals(0, array[5]);
    }


    /**
     * ▄ █               ▄ █
     * ▄ █ █ █  -->      ▄ █ █ █
     * ▄ █ █ █ █ █       ▄ █ █ █ █ █
     */
    @Test(timeout = TIMEOUT)
    public void shouldNotChangeAlreadySortedArrayWithEvenLength() {
        int[] array = new int[6];
        array[0] = 3;
        array[1] = 4;
        array[2] = 5;
        array[3] = 6;
        array[4] = 7;
        array[5] = 8;
        algorithm.sort(array);
        assertEquals(3, array[0]);
        assertEquals(4, array[1]);
        assertEquals(5, array[2]);
        assertEquals(6, array[3]);
        assertEquals(7, array[4]);
        assertEquals(8, array[5]);
    }


    /**
     * :          ▄                 ▄
     * ▄ █ █  -->        ▄ █ █
     * ▄ █ █ █ █ █       ▄ █ █ █ █ █
     */
    @Test(timeout = TIMEOUT)
    public void shouldNotChangeAlreadySortedArrayWithEvenLengthWithDuplicates() {
        int[] array = new int[6];
        array[0] = 1;
        array[1] = 2;
        array[2] = 2;
        array[3] = 4;
        array[4] = 5;
        array[5] = 6;
        algorithm.sort(array);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(2, array[2]);
        assertEquals(4, array[3]);
        assertEquals(5, array[4]);
        assertEquals(6, array[5]);
    }


    /**
     * :        ▄ █            ▄ █
     * :    ▄ █ █ █  -->   ▄ █ █ █
     * :  █ █ █ █ █      █ █ █ █ █
     */
    @Test(timeout = TIMEOUT)
    public void shouldNotChangeAlreadySortedArrayWithOddLength() {
        int[] array = new int[5];
        array[0] = 2;
        array[1] = 3;
        array[2] = 4;
        array[3] = 5;
        array[4] = 6;
        algorithm.sort(array);
        assertEquals(2, array[0]);
        assertEquals(3, array[1]);
        assertEquals(4, array[2]);
        assertEquals(5, array[3]);
        assertEquals(6, array[4]);
    }


    /**
     * :         ▄ █             ▄ █
     * :   ▄ ▄ █ █ █ -->   ▄ ▄ █ █ █
     * : █ █ █ █ █ █     █ █ █ █ █ █
     */
    @Test(timeout = TIMEOUT)
    public void shouldNotChangeAlreadySortedArrayWithOddLengthWithDuplicates() {
        int[] array = new int[5];
        array[0] = 2;
        array[1] = 3;
        array[2] = 4;
        array[3] = 5;
        array[4] = 6;
        algorithm.sort(array);
        assertEquals(2, array[0]);
        assertEquals(3, array[1]);
        assertEquals(4, array[2]);
        assertEquals(5, array[3]);
        assertEquals(6, array[4]);
    }


    /**
     * : █ █      █ █
     * : █ █  --> █ █
     * : █ █      █ █
     */
    @Test(timeout = TIMEOUT)
    public void shouldNotChangeTwoElementArrayWithDuplicates() {
        int[] array = new int[2];
        array[0] = 0;
        array[1] = 0;
        algorithm.sort(array);
        assertEquals(0, array[0]);
        assertEquals(0, array[1]);
    }


    /**
     * █      █
     * █ ---> █
     * █      █
     */
    @Test(timeout = TIMEOUT)
    public void shouldNotChangeOneElementArray() {
        int[] array = new int[1];
        array[0] = 42;
        algorithm.sort(array);
        assertEquals(42, array[0]);
        assertEquals(1, array.length);
    }


    /*------------------------------------------------------- MINIMAL ------------------------------------------------*/
    /*Some tests that pass if something no matter how small is done in the right direction*/


    /**
     * █               █
     * █ ▄ █     -x->  █ ▄ █
     * █ █ █ █ ▄       █ █ █ █ ▄
     */
    @Test(timeout = TIMEOUT)
    public void shouldDoAtLeastSomething() {
        int[] array = new int[5];
        array[0] = 8;
        array[1] = 4;
        array[2] = 5;
        array[3] = 3;
        array[4] = 1;
        int[] old = new int[5];
        System.arraycopy(array, 0, old, 0, 5);
        algorithm.sort(array);
        int changes = 0;
        for (int i = 0; i < 5; i++) {

            if (old[i] != array[i])
                changes++;
        }
        assertTrue(changes > 0);
    }


    /**
     * :
     * : int[5]    --> int[5]
     * :
     */
    @Test(timeout = TIMEOUT)
    public void arrayShouldNotChangeSizeBySorting() {
        int[] array = new int[5];
        array[0] = 8;
        array[1] = 4;
        array[2] = 5;
        array[3] = 3;
        array[4] = 1;
        algorithm.sort(array);
        assertEquals(5, array.length);
    }


    /**
     * █             █   x x
     * █ ▄ █     --> █ ▄   █
     * █ █ █ █ ▄     █ █ █ █ ▄
     * 8 4 5 3 1     8 4 3 5 1
     * Doesn't have to be sorted but the numbers are the same
     */
    @Test(timeout = TIMEOUT)
    public void shouldContainSameNumbers() {
        int[] array = new int[5];
        array[0] = 8;
        array[1] = 4;
        array[2] = 5;
        array[3] = 3;
        array[4] = 1;
        int[] old = new int[5];
        System.arraycopy(array, 0, old, 0, 5);
        algorithm.sort(array);
        int count;
        for (int i = 0; i < 5; i++) {
            count = 0;
            for (int j = 0; j < 5; j++) {
                if (old[i] == array[j]) {
                    count++;
                }
            }
            assertTrue(count > 0);
        }
    }


    /**
     * █               █
     * █ ▄ █     --> ! █ ▄   █
     * █ █ █ █ ▄     ▄ █ █ █ █
     * 8 4 5 3 1     1 8 4 3 5
     */
    @Test(timeout = TIMEOUT)
    public void smallestShouldBeFirst() {
        int[] array = new int[5];
        array[0] = 8;
        array[1] = 4;
        array[2] = 5;
        array[3] = 3;
        array[4] = 1;
        algorithm.sort(array);
        assertEquals(1, array[0]);
    }


    /**
     * █                █
     * █ ▄ █     -X-> █ █ ▄   !
     * █ █ █ ▄ █      █ █ █ █ ▄
     * 8 4 5 1 3      * * * * 1
     */
    @Test(timeout = TIMEOUT)
    public void smallestShouldNotBeLast() {
        int[] array = new int[5];
        array[0] = 8;
        array[1] = 4;
        array[2] = 5;
        array[3] = 1;
        array[4] = 3;
        algorithm.sort(array);
        assertNotEquals(1, array[4]);
    }


    @Test(timeout = TIMEOUT)
    public void largestShouldBeLast() {
        int[] array = new int[5];
        array[0] = 6;
        array[1] = 4;
        array[2] = 5;
        array[3] = 3;
        array[4] = 1;
        algorithm.sort(array);
        assertEquals(6, array[4]);
    }


    @Test(timeout = TIMEOUT)
    public void largestShouldNotBeFirst() {
        int[] array = new int[5];
        array[0] = 4;
        array[1] = 6;
        array[2] = 5;
        array[3] = 1;
        array[4] = 3;
        algorithm.sort(array);
        assertNotEquals(6, array[0]);
    }


    /*----------------------------------------------------- ADVANCED ------------------------------------------------*/
    /*This Tests are designed to try to trick the Algorithm*/


    /**
     * █ █ █ █         █ █ █ █
     * █ █ █ █   -->   █ █ █ █
     * █ █ █ █ ▄     ▄ █ █ █ █
     */
    @Test(timeout = TIMEOUT)
    public void ShouldSortSpecialCase1() {
        int[] array = new int[5];
        array[0] = 42;
        array[1] = 42;
        array[2] = 42;
        array[3] = 42;
        array[4] = 1;
        algorithm.sort(array);
        assertNotEquals(42, array[0]);
        assertEquals(1, array[0]);
        assertEquals(42, array[1]);
        assertEquals(42, array[2]);
        assertEquals(42, array[3]);
        assertEquals(42, array[4]);
    }


    /**
     * :     █             █
     * : ▄ ▄ █ ▄ ▄ --> ▄ ▄ █ ▄ ▄
     * : █ █ █ █ █     █ █ █ █ █
     */
    @Test(timeout = TIMEOUT)
    public void ShouldSortSpecialCase2() {
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;
        array[3] = 1;
        array[4] = 1;
        algorithm.sort(array);
        assertEquals(1, array[0]);
        assertEquals(1, array[1]);
        assertEquals(1, array[2]);
        assertEquals(1, array[3]);
        assertEquals(2, array[4]);
    }


    @Test(timeout = TIMEOUT)
    public void shouldSortSpecialCase3PivotIsSmallest() {
        int[] array = new int[4];
        array[0] = 4;
        array[1] = -6;
        array[2] = -1;
        array[3] = 10;
        algorithm.sort(array);
        assertEquals(-6, array[0]);
        assertEquals(-1, array[1]);
        assertEquals(4, array[2]);
        assertEquals(10, array[3]);
    }


    @Test(timeout = TIMEOUT)
    public void shouldSortSpecialCase4PivotIsBiggest() {
        int[] array = new int[4];
        array[0] = 4;
        array[1] = 4;
        array[2] = -5;
        array[3] = -9;
        algorithm.sort(array);
        assertEquals(-9, array[0]);
        assertEquals(-5, array[1]);
        assertEquals(4, array[2]);
        assertEquals(4, array[3]);
    }


    /**
     * :   █ █ █           █ █ █
     * : ▄ █ █ █ ▄ --> ▄ ▄ █ █ █
     * : █ █ █ █ █     █ █ █ █ █
     */
    @Test(timeout = TIMEOUT)
    public void ShouldSortArrayWithDuplicatePivot() {
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 2;
        array[3] = 2;
        array[4] = 1;
        algorithm.sort(array);
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
    @Test(timeout = TIMEOUT)
    public void shouldSortConsistentArrayWithOneException() {
        int[] array = new int[5];
        array[0] = 2;
        array[1] = 3;
        array[2] = 5;
        array[3] = 1;
        array[4] = 6;
        algorithm.sort(array);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
        assertEquals(5, array[3]);
        assertEquals(6, array[4]);
    }


    /**
     * If this Test fails and all the other tests are successful, then you just fund an unchecked testcase--> add it
     */
    @Test(timeout = 10000)
    public void bruteForce() {
        int length;
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            length = random.nextInt(15)+1;
            int[] array = new int[length];
            int[] reference = new int[length];
            for (int j = 0; j < length; j++) {
                array[j] = random.nextInt(21) - 10;
            }
            System.arraycopy(array, 0, reference, 0, length);
            System.out.println("run "+i);
            System.out.println("unsorted:" + Arrays.toString(reference));
            algorithm.sort(array);
            System.out.println("sorted  :" + Arrays.toString(array));
            Arrays.sort(reference);
            System.out.println("expected:" + Arrays.toString(reference));
            for (int j = 0; j < length; j++) {
                assertEquals(reference[j], array[j]);
            }
        }
    }
}