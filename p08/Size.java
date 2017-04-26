package p08;


/**
 * @author Stephan Graf
 * @since 2017-04-26
 */
public enum Size {
    SMALL(100), MEDIUM(100000), LARGE(Integer.MAX_VALUE);
    private final int value;

    Size(int value) {
        this.value = value;
    }

}
