package p08;


/**
 * @author Stephan Graf
 * @since 2017-04-26
 * Measure the speed of different sorting Algorithms.
 */
public class TimeMeter {
    private static final int CYCLES = 10000;


    public TimeMeter() {

    }


    public int measure(SortingAlgorithm algorithm, int[] array) {
        // TODO: 26.04.17 review notes from last semester
        int totalTime = 0;
        //warmup
        for (int i = 0; i < 1000; i++) {

        }
        for (int i = 0; i < CYCLES; i++) {
            for (int j = 0; j < 10; j++) {
               algorithm.sort(array);
            }
        }
        return totalTime / CYCLES;
    }
}
