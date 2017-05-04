package p08;


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
        if (pivotPoint - low > 1) {
            if (pivotPoint - low > TRESHOLD) {
                Thread thread=new Thread((Runnable)new QuickSortTurboThread(array,low,pivotPoint-1));
                thread.start();
            } else {
                insertionSort.sort(array, low, pivotPoint);
            }
        }

        if (high - pivotPoint > 1) {
            if (high - pivotPoint > TRESHOLD) {
                Thread thread2=new Thread(new QuickSortTurboThread(array,pivotPoint+1,high));
                thread2.start();
            } else {
                insertionSort.sort(array, pivotPoint, high);
            }
        }
    }


    protected int getPivotIndex(int[] array, int low, int high) {
        return ((high - low) / 2) + low;
    }
}
