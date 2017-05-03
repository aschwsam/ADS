package p08;


import java.util.ArrayList;


/**
 * @author Stephan Graf
 * @since 2017-04-26
 * Measure the different run times of different algorithms with different arrays (size and containing numbers)
 */
public class Main {
    private static ArrayList<SortingAlgorithm> algorithms = new ArrayList<>();

    public static void main(String[] args) {
        algorithms.add(new QuickSort3());
        algorithms.add(new QuickSortTurbo());
        algorithms.add(new MedianQuickSort());
        algorithms.add(new InsertionSort());

        for (SortingAlgorithm algorithm : algorithms) {
            for (InputTypeCategory inputTypeCategory : InputTypeCategory.values()) {
                for (ArraySizeCategory arraySizeCategory : ArraySizeCategory.values()) {
                    float result = TimeMeter.measureNanoSeconds(algorithm, arraySizeCategory, inputTypeCategory)/1000;
                    System.out.println(algorithm.toString() + " (" + inputTypeCategory.toString() + ") with " + arraySizeCategory.value + "elements:    " + result+"ms");
                }
            }
            System.out.println("\n");
        }
    }
}
