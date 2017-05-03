package p08;

/**
 * @author Stephan Graf
 * @since 2017-04-26
 */
public enum ArraySizeCategory {
    SMALL(10), MEDIUM(10000), LARGE(1000000);
    public final int value;
    ArraySizeCategory(int value) {
        this.value = value;
    }
}