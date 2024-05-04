package sortingcomplexity;

public class OptimizedBubbleSort implements ISort {
    private long counter;

    public OptimizedBubbleSort() {
        counter = 0;
    }
    public <T extends Comparable<T>> void sort(T[] vector) {

    }

    public void sort(int[] vector) {
        int n = vector.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                counter += 1; // i=1
                if (vector[i - 1] > vector[i]) {
                    counter += 1; // Comparison
                    // Swap vector[i-1] and vector[i]
                    Sort.swap(vector, i - 1, i);
                    counter += 3; // 3 assignments to swap values
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
    public long getCounter() {
        return counter;
    }
}
