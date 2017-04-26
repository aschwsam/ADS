package p08;


public class Quicksort2 implements SortingAlgorithm {
    public int[] sort(int[] numbers) {
        if (isSortable(numbers)) {
            for (int i = 1; i < numbers.length; i++) {
                int j = i;
                while (j > 0 && numbers[j - 1] > numbers[j]) {
                    swap(j, j - 1, numbers);
                    j--;
                }
            }
        }
        return numbers;
    }


    public static void quicksortClassic(int[] numbers, int low, int high) {
        if (isSortable(numbers)) {
            int pivot = partition(numbers,0,numbers.length-1);
            low= numbers[0];
            high = numbers.length-1;
            if (low < high) {
                quicksortClassic(numbers, low, pivot - 1);
                quicksortClassic(numbers, pivot + 1, high);
            }
        }
    }
    private static int partition(int[] array, int low,  int high){
        int pivot = array[high];
        int i= low -1;
        for (int j = low; j < high; j++) {
            if(array[j]<=pivot){
            i++;
            swap(i,j,array);
            }
        }
        return ++i;
        }

    private static Boolean isSortable(int[] array) {
        return array != null && array.length > 1;
    }


    private static void swap(int indexA, int indexB, int[] array) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

}
