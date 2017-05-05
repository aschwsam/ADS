package p08;


import java.util.Arrays;


/**
 * @author Stephan Graf
 * @since 01.05.17
 */
public class QuickSortSuperTurbo extends SortingAlgorithm {
    final static int TRESHOLD = 12;

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] array, int low, int high) {
        InsertionSort insertionSort = new InsertionSort();
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
        int[]lower=new int[(pivotPoint)-low];
        if (pivotPoint - low > 1) {
            lower=Arrays.copyOfRange(array, low, pivotPoint-1);

            if (pivotPoint - low > TRESHOLD) {
                Thread thread=new Thread(new QuickSortTurboThread(lower));
                thread.start();
            } else {
                insertionSort.sort(array, low, pivotPoint);
            }
        }
        int[]higher=new int[high-pivotPoint+1];
        Thread thread2=new Thread();
        if (high - pivotPoint > 1) {
            higher=Arrays.copyOfRange(array,pivotPoint+1,high);
                 thread2=new Thread(new QuickSortTurboThread(higher));
                thread2.start();
        }
        if(thread2!=null){
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int l=0;
        for(int k:lower){
            array[l]=k;
            l++;
        }
        for(int m:higher){
            array[l]=m;
            l++;
        }
    }


    protected int getPivotIndex(int[] array, int low, int high) {
        return ((high - low) / 2) + low;
    }
}
