package p08;


import java.util.ArrayList;
import java.util.Random;


/**
 * @author Stephan Graf
 * @since 2017-04-26
 * Measure the speed of different sorting Algorithms.
 */
abstract class TimeMeter {
    private static final int CYCLES = 10000;


    static int measureNanoSeconds(SortingAlgorithm algorithm, ArraySizeCategory arraySizeCategory, InputTypeCategory inputTypeCategory) {
        ArrayList<int[]> arrays = new ArrayList();
        for (int i = 0; i < CYCLES/100; i++) {
            arrays.add(createArray(inputTypeCategory, arraySizeCategory.value));
        }
        //warmup
        for (int[] array : arrays) {
            algorithm.sort(array);
        }
        //the real deal
        long startTime = System.nanoTime();
        for (int[] array : arrays) {
            for (int i = 0; i <100 ; i++) {
                algorithm.sort(array);
            }
        }
        long endTime = System.nanoTime();
        return (int)((endTime - startTime) / CYCLES );
    }


    private static int[] createArray(InputTypeCategory inputTypeCategory, int size) {
        int[] array = new int[size];
        Random rn = new Random();
        switch (inputTypeCategory) {
            case EMPTY:
                return array;
            case RANDOM:
                for (int i = 0; i < size; i++) {
                    array[i] = rn.nextInt(10);
                }
                break;
            case SORTED:
                int last = 0;
                int current = 0;
                for (int i = 0; i < size; i++) {
                    while (!(current >= last)) {
                        current = rn.nextInt(10);
                    }
                    array[i] = current;
                    last = current;
                }
                break;
            case ALMOST:
                int cuckoosEggs = array.length / 100;
                int position;
                last = 0;
                current = 0;
                for (int i = 0; i < size; i++) {
                    while (!(current >= last)) {
                        current = rn.nextInt(10);
                    }
                    array[i] = current;
                    last = current;
                }
                for (int i = 0; i < cuckoosEggs; i++) {
                    position = rn.nextInt(array.length);
                    array[position] = array[position] - 1;
                }
                break;
            case DESCENDING:
                last = 0;
                current = 0;
                for (int i = 0; i < size; i++) {
                    while (!(current <= last)) {
                        current = rn.nextInt(10);
                    }
                    array[i] = current;
                    last = current;
                }
                break;
        }
        return array;
    }
}
