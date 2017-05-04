package p08;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;


/**
 * @author Stephan Graf
 * @since 02.05.17
 */
public class BetterMedianQuickSort extends QuickSort3 {

    @Override
    protected int getPivotIndex(int[] array, int low, int high) {
        //todo add distinc
        int[] ints = new Random().ints(low, high-low).limit(6).toArray();
        HashMap<Integer, Integer> medianPointers = new HashMap<>();
        for (int i : ints) {
            medianPointers.put(array[i], i);
        }
        int[] a = new int[medianPointers.size()];
        int j = 0;
        for (Integer i : medianPointers.keySet()) {
            a[j] = i;
            j++;
        }
        return medianPointers.get(median(a));
    }


    static int median(int[] array) {
        Arrays.sort(array);
        int middle = array.length / 2;
        if (array.length % 2 == 1) {
            return array[middle];
        } else {
            return (array[middle - 1]);
        }
    }
}
