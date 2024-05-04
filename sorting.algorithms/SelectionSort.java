package sorting.algorithms;

public class SelectionSort extends Sort {

    @Override
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
                swap(vector, i, p);
        }
    }

}
