package p08;


/**
 * @author Stephan Graf
 * @since 04.05.17
 */
public class QuickSortTurboThread extends QuickSortTurbo implements Runnable{
    private final int[] array;
    private final int low;
    private final int high;
    public QuickSortTurboThread(int[] array, int low, int high) {

        this.array = array;
        this.low=low;
        this.high=high;
    }
    public void run(){
        super.sort(array,low,high);
    }

}
