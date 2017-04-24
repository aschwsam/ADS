package p08;

public class Quicksort {

    public static void main(String Args[]){
        int[] numbers = {1,4,2,7,5,8,2,3,9};


        System.out.println("===== INIT =====>");
        for(int asd : numbers){
            System.out.println("\t"+asd);
        }
        System.out.println("==========>");

        sort(numbers);
    }

    public static void sort(int[] numbers){

        int init_pivot = (int)Math.floor(numbers.length/2);
        int new_pivot = init_pivot;
        boolean change = false;

        // left (lower) part
        for(int index=0;index<init_pivot;index++){
            if(numbers[index]>numbers[init_pivot]){
                int tmp = numbers[index];
                numbers[index] = numbers[init_pivot];
                numbers[init_pivot] = tmp;

                new_pivot = index;
                change = true;
            }
        }

        System.out.println("==========>");
        for(int asd : numbers){
            System.out.println("\t"+asd);
        }
        System.out.println("====="+new_pivot+"=====>");

        // right (higher) part
        for(int index=init_pivot;index<numbers.length;index++){
            if(numbers[index]<numbers[new_pivot]){
                int tmp = numbers[index];
                numbers[index] = numbers[new_pivot];
                numbers[new_pivot] = tmp;

                new_pivot = index;
                change = true;
            }
        }

        System.out.println("==========>");
        for(int asd : numbers){
            System.out.println("\t"+asd);
        }
        System.out.println("==========>");

        if(change){
            sort(numbers);
        }
    }
}
