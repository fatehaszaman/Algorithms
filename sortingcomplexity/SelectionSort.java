package sortingcomplexity;

public class SelectionSort implements ISort {
    private long counter;

    public SelectionSort() {
        counter = 0;
    }

    public <T extends Comparable<T>> void sort(T[] vector) {

    }
    public void sort(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            int p = i;

            // p holds the index of the smallest value of the unsorted part of the array

            for (int j = i + 1; j < vector.length; j++) {
                counter += 1; // Increment for the comparison
                if (vector[j] < vector[p]) {
                    p = j;
                }
            }

            if (p != i) {
                swap(vector, i, p);
                counter += 3; // Increment for 3 assignments
            }
        }
    }
    public long getCounter() {
        return counter;
    }

    private void swap(int[] vector, int i, int j) {
        int temp = vector[i];
        vector[i] = vector[j];
        vector[j] = temp;
        counter += 3; // Increment for 3 assignments
    }
}
