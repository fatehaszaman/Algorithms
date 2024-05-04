package sortingcomplexity;

public class HoareQuicksort implements ISort {
    private long counter;

    public HoareQuicksort() {
        counter = 0;
    }

    private int partition(int[] vector, int low, int high) {
        int pivot = vector[low];
        int p = low - 1;
        int q = high + 1;
        while (true) {
            do {
                p++;
                counter += 1; // Increment for the comparison
            } while (vector[p] < pivot); // finds the leftmost element >= pivot

            do {
                q--;
                counter += 1; // Increment for the comparison
            } while (vector[q] > pivot); // finds the rightmost element <= pivot

            if (p >= q) {
                return q;
            }

            swap(vector, p, q);
            counter += 3; // Increment for 3 assignments
        }
    }

    private void sort(int[] vector, int low, int high) {
        if (low < high) {
            int p = partition(vector, low, high);
            sort(vector, low, p);
            sort(vector, p + 1, high);
        }
    }

    public <T extends Comparable<T>> void sort(T[] vector) {

    }

    public void sort(int[] vector) {
        sort(vector, 0, vector.length - 1);
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
