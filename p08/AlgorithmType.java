package p08;


/**
 * @author Stephan Graf
 * @since 2017-04-26
 */
public enum AlgorithmType {
    INSERTION(Insertionsort.class), QUICK(Quicksort.class);
    //,MERGE,JAVA

    private final Class value;


    AlgorithmType(Class value) {
        this.value = value;
    }
}
