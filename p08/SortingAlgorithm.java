package p08;

import java.util.Arrays;

/**
 * @author Stephan Graf
 * @since 02.05.17
 * Represent a Sorting Algorithm. Contains some basic helper methods for sorting algorithms.
 */
public abstract class SortingAlgorithm {

    static void swap(int i, int j, int[] array) {
        // System.out.println("swap array[" + i + "]:" + array[i] + " with array[" + j + "]:" + array[j]);
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static Boolean isSortable(int[] array) {
        return array != null && array.length > 1;
    }

    public void sort(int[] array) {
        Arrays.sort(array);
    }

    public String toString(){
        return this.getClass().toString();
    }
}
