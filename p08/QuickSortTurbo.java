package p08;


import java.util.Arrays;


/**
 * @author Stephan Graf
 * @since 01.05.17
 */
public class QuickSortTurbo extends SortingAlgorithm {
    final static int TRESHOLD=10;


    @Override
    public void sort(int[] array) {
      quickSort(array,0,array.length-1);
    }
    public void quickSort(int[] array, int low, int high){
        InsertionSort insertionSort=new InsertionSort();
        //System.out.println("quicksort");
        int pivotPoint = getPivotIndex(array, low, high);
        int i = low;
        int j = high;
        while (j - i > 0) {
            //from left, goto first bigger than pivot
            while (array[i] <= array[pivotPoint] && i < pivotPoint) {
                i++;
            }
            //from right goto first smaller than pivot
            while (array[j] >= array[pivotPoint] && j > pivotPoint) {
                j--;
            }
            swap(i, j, array);
            //if pivot element got swapped adjust pivotPoint
            if (i == pivotPoint) {
                pivotPoint = j;
            } else if (j == pivotPoint) {
                pivotPoint = i;
            }
        }
    if(pivotPoint-low >TRESHOLD || high -pivotPoint>TRESHOLD){
        if (pivotPoint - low > 1) {
            quickSort(array, low, pivotPoint - 1);
        }
        if (high - pivotPoint > 1) {
            quickSort(array, pivotPoint + 1, high);
        }
        }else{
            if (pivotPoint - low > 1) {
                insertionSort.sort(Arrays.copyOfRange(array,low, pivotPoint - 1));
            }
            if (high - pivotPoint > 1) {
                insertionSort.sort(Arrays.copyOfRange(array,pivotPoint+1, high));
            }
        }
    }



    protected int getPivotIndex(int[] array, int low, int high) {
        return ((high - low) / 2) + low;
    }
}
