package p08;


class InsertionSort extends SortingAlgorithm{

    @Override
    public void sort(int[] array) {
        if (isSortable(array)) {
            for (int start = 1; start < array.length; start++) {
                int preview = start;
                while (preview > 0) {
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

}
