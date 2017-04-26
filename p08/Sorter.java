package p08;

import java.util.Arrays;

public class Sorter{
    Class algorithm;
	
	public static void sort(int[] numbers) {
		if(numbers != null){

			Arrays.sort(numbers);
		}
	}

	public void setAlgorithm(AlgorithmType algorithm){
        switch (algorithm){
            case QUICK: this.algorithm=Quicksort.class;
        }
    }
}
