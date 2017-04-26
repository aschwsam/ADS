package p08;


import java.util.Random;

/**
 * @author Stephan Graf
 * @since 2017-04-26
 * Measure the different runtimes of different algorithms
 */
public class Main {

    public static void main(String[] args) {
        for (AlgorithmType algorithm : AlgorithmType.values()) {
            for (InputType inputType : InputType.values()) {
                for (Size size : Size.values()) {
                    TimeMeter timeMeter = new TimeMeter();
                    int result = timeMeter.measure(algorithm, createArray(inputType, 1000));
                    System.out.println(algorithm.toString() + " (" + inputType.toString() + ") with " + size +"elements" + result);
                }
            }
            System.out.println("\n");
        }
    }


    private static int[] createArray(InputType inputType, int size) {
        //todo add almost and descending
        int[] array = new int[size];
        Random rn = new Random();
        switch (inputType) {
            case EMPTY:
                return array;
            case RANDOM:
                for (int i = 0; i < size; i++) {
                    array[i] = rn.nextInt(10);
                }
                break;
            case ASCENDING:
                int last=0;
                int actual=0;
                for (int i = 0; i < size; i++) {
                    array[i] = rn.nextInt(10);
                }
                break;
        }
        return array;
    }
}
