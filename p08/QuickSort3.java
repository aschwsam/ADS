package p08;


import java.util.Arrays;


/**
 * @author Stephan Graf
 * @since 28.04.17
 */
public class QuickSort3 implements SortingAlgorithm {
    public static void sort(int[] array) {
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        int pivotPoint = getPivotIndex(low, high);
        int pivot = array[pivotPoint];
        int i = low;
        int j = high;
        while (j-i>1) {
            while (array[i] <= pivot &&i<pivotPoint) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
                if (i == pivotPoint) {
                    pivotPoint = j;
                } else if (j == pivotPoint) {
                    pivotPoint = i;
                }

                swap(i, j, array);
        }
        if (pivotPoint - low >1) {
            quickSort(array, low, pivotPoint-1);
        }
        if (high - pivotPoint > 1) {
            quickSort(array, pivotPoint+1, high);
        }

    }


    private static void swap(int i, int j, int[] array) {
        System.out.println("swap array[" + i + "]:" + array[i] + " with array[" + j + "]:" + array[j]);
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private static int getPivotIndex(int low, int high) {
        return (((high - low)) / 2) + low;
    }
}
