package sorting.generics;

public class SelectionSort extends Sort {


    public void sort(int[] vector) {
        for (int i=0; i<vector.length-1; i++) {
            int p = i;

            // p holds the index of the smallest value of the unsorted part of the array

            for (int j=i+1; j<vector.length; j++) {
                if (vector[j] < vector[p]){
                    p = j;
                }
            }

            if (p != i)
                swap(new int[][]{vector}, i, p);
        }
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] vector, ISortingOrder sorting) {

    }
}
