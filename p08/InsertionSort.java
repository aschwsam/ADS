package p08;


class InsertionSort extends SortingAlgorithm{

    public void sort(int[] array){
        sort(array,0,array.length-1);
    }

    public void sort(int[] array, int low, int high) {
            for (int start = low; start <= high; start++) {
                int preview = start;
                while (preview > low) {
                    if (array[preview - 1] > array[preview]) {
                        int tmp = array[preview - 1];
                        array[preview - 1] = array[preview];
                        array[preview] = tmp;
                    }
                    preview--;
                }
            }
        }
}
