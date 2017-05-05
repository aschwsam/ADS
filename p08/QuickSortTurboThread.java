package p08;


/**
 * @author Stephan Graf
 * @since 04.05.17
 */
public class QuickSortTurboThread extends QuickSortTurbo implements Runnable{
    private final int[] array;
    public QuickSortTurboThread(int[] array) {
        this.array = array;
    }
    public void run(){
        super.sort(array);
    }

}
