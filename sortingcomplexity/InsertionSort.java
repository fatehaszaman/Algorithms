package sortingcomplexity;

public class InsertionSort implements ISort {
    private long counter;

    public InsertionSort() {
        counter = 0;
    }
    public <T extends Comparable<T>> void sort(T[] vector) {

    }
    public void sort(int[] vector) {
        for (int i = 1; i < vector.length; i++) {
            int j = i;

            while (j > 0 && vector[j - 1] > vector[j]) {
                Sort.swap(vector, j - 1, j);
                counter += 4; // Increment for each assignment and comparison

                j--;
            }
        }
    }
    public long getCounter() {
        return counter;
    }
}
