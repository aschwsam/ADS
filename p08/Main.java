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
        algorithms.add(new SortingAlgorithm() {
            @Override
            public void sort(int[] array) {
                super.sort(array);
            }
        });

        //algorithms.add(new InsertionSort());
        algorithms.add(new QuickSort3());
        //algorithms.add(new QuickSortTurbo());
        algorithms.add(new MedianQuickSort());
        algorithms.add(new QuickSortSuperTurbo());
        test();
        /*for (SortingAlgorithm algorithm : algorithms) {
            for (InputTypeCategory inputTypeCategory : InputTypeCategory.values()) {
                for (ArraySizeCategory arraySizeCategory : ArraySizeCategory.values()) {
                    double result = TimeMeter.measureNanoSeconds(algorithm, arraySizeCategory.value, inputTypeCategory) / 1000.0;
                    System.out.print(algorithm.toString() + " (" + inputTypeCategory.toString() + ") with " + arraySizeCategory.value + "elements:    ");
                    System.out.printf("%.3d ms\n", result);
                }
            }
            System.out.println("\n");
        }
        */


    }


    private static void test() {
        //for (int i=0;i<100;i++) {
        for (SortingAlgorithm algorithm : algorithms) {
                    double result = TimeMeter.measureNanoSeconds(algorithm, 5000, InputTypeCategory.RANDOM) / 1000.0;
                    System.out.print(algorithm.toString() + " (" + InputTypeCategory.RANDOM.toString() + ") with " + 5000 + "elements:    ");
                    System.out.printf("%.3f ms\n", result);
                }
            System.out.println("\n");
        }
    //}
}
