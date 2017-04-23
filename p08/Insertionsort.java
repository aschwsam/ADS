package p08;

public class Insertionsort {

    public static void sort(int[] numbers){

        if(numbers != null && numbers.length>1){

            for(int start=1;start<numbers.length;start++){

                int preview = start;

                while(preview>0) {
                    if (numbers[preview-1] > numbers[preview]) {

                        int tmp = numbers[preview-1];

                        numbers[preview-1] = numbers[preview];
                        numbers[preview] = tmp;

                        preview--;
                    } else {
                        preview--;
                    }
                }
            }
        }
    }

}
