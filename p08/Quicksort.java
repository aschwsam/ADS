package p08;

/**
 * TODO: THIS IMPLEMENTATION IS BS!
 * TODO: DON'T USE IT^^
 */

public class Quicksort {

    public static void main(String Args[]){
        int[] numbers = {4,3,2,7,2,8,5,6,1};
        sort(numbers);
    }

    public static void sort(int[] numbers){

        if(numbers.length==1 || numbers.length<1){
            return;
        } else {
            sort(numbers,0,numbers.length-1);
            for(int asd : numbers){
                System.out.println(asd);
            }
        }
    }

    public static void sort(int[] numbers,int low_index, int high_index){
        // Define pivot
        int pivot_value = numbers[(int)Math.floor(numbers.length/2)];

        boolean move_element = true;

        while(move_element){

            // Find bigger number OR pivot
            while(low_index<high_index && numbers[low_index]<pivot_value){
                low_index++;
            }

            while(high_index>low_index && numbers[high_index]>pivot_value){
                high_index--;
            }

            // DEBUG
            System.out.println("Swap low: "+numbers[low_index]+" ("+low_index+") with high: "+numbers[high_index]+" ("+high_index+")");

            int tmp = numbers[low_index];
            numbers[low_index] = numbers[high_index];
            numbers[high_index] = tmp;

            if(numbers[low_index] == numbers[high_index]){
                move_element=false;
            }
        }
    }
}
