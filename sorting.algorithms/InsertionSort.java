package sorting.algorithms;

public class InsertionSort extends Sort {

    @Override
    public void sort(int[] vector) {
        for (int i=1; i<vector.length; i++) {
            int j=i;

            while (j>0 && vector[j - 1] > vector[j]) {
                swap(vector, j-1, j);

                j--;
            }
        }
    }

}