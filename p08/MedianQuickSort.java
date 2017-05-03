package p08;


import java.util.Arrays;
import java.util.HashMap;


/**
 * @author Stephan Graf
 * @since 02.05.17
 */
public class MedianQuickSort extends QuickSort3 {

    @Override
    protected int getPivotIndex(int[] array, int low, int high){
        int middle=super.getPivotIndex(array,low,high);
        HashMap<Integer,Integer> medianPointers = new HashMap<>();
        medianPointers.put(array[low],low);
        medianPointers.put(array[high],high);
        medianPointers.put(array[middle],middle);
        int[] a=new int[medianPointers.size()];
        int j=0;
        for (Integer i : medianPointers.keySet()){
            a[j]=i;
            j++;

        }
                return medianPointers.get(median(a));
    }

    private int median(int[] array){
        Arrays.sort(array);
        int middle = array.length/2;
        if (array.length%2 == 1) {
            return middle;
        } else {
            return (array[middle-1] + array[middle]) / 2;
        }
    }
}
