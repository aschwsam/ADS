package p08;

/**
 * TODO: THIS IMPLEMENTATION IS BS!
 * TODO: DON'T USE IT^^
 */

public class Quicksort {

    public static void main(String Args[]){
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        //sort(numbers);
    }

    public static void sort(int[] numbers){

        if(numbers.length==1 || numbers.length<1){
            return;
        }

        // Define pivot
         int pivot_position = (int)Math.floor(numbers.length/2);
         int pivot_value = numbers[pivot_position];

        int low_index = 0;
        int high_index = numbers.length-1;

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
             System.out.println("Swap low: "+low_index+" ("+numbers[low_index]+") with high: "+high_index+" ("+numbers[high_index]+")");

             int tmp = numbers[low_index];
             numbers[low_index] = numbers[high_index];
             numbers[high_index] = tmp;

             if(numbers[low_index] == numbers[high_index]){
                 move_element=false;
             }
         }
    }
}
