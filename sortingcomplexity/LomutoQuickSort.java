package sortingcomplexity;

public class LomutoQuickSort implements ISort {
    private long counter;

    public LomutoQuickSort() {
        counter = 0;
    }

    public <T extends Comparable<T>> void sort(T[] vector) {

    }

    public void sort(int[] vector) {
        sort(vector, 0, vector.length - 1);
    }

    private void sort(int[] vector, int low, int high) {
        if (low < high) {
            int p = partition(vector, low, high);
            sort(vector, low, p - 1);
            sort(vector, p + 1, high);
        }
    }

    private int partition(int[] vector, int low, int high) {
        int pivot = vector[high];
        int p = low;

        for (int q = low; q < high; q++) {
            counter += 1; // Increment for the comparison
            if (vector[q] < pivot) {
                swap(vector, p, q);
                p++;
            }
        }

        swap(vector, p, high);
        counter += 3; // Increment for 3 assignments

        return p;
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
