package sorting.algorithms;


public class HoareQuicksort extends Sort {

    private static int partition(int[] vector, int low, int high) {
        int pivot = vector[low];
        int p = low - 1;
        int q = high + 1;
        while (true) {
            do {
                p++;
            } while (vector[p] < pivot); // findsV the leftmost element >= pivot
            do {
                q--;
            } while (vector[q] > pivot); // finds the rightmost element <= pivot
            if (p >= q)
                return q;
            swap(vector, p, q);
        }
    }

    private static void sort(int[] vector, int low, int high) {
        if (low < high) {
            int p = partition(vector, low, high);
            sort(vector, low, p);
            sort(vector, p + 1, high);
        }
    }

    public void sort(int[] vector) {
        sort(vector, 0, vector.length - 1);



    }
}


