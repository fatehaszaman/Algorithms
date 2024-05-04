package sorting.generics;

public class InsertionSort extends Sort {


    public void sort(int[] vector) {
        for (int i=1; i<vector.length; i++) {
            int j=i;

            while (j>0 && vector[j - 1] > vector[j]) {
                swap(new int[][]{vector}, j-1, j);

                j--;
            }
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] vector, ISortingOrder sorting) {

    }
}