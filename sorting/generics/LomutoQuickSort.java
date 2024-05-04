package sorting.generics;



public class LomutoQuickSort extends Sort {

    private static int partition(int[] vector, int low, int high) {
        int pivot=vector[high];

        int p=low;

        for(int q=low; q<high; q++)
            if (vector[q] < pivot) {
                swap(new int[][]{vector}, p, q);
                p++;
            }

        swap(new int[][]{vector}, p, high);

        return p;
    }

    private static void sort(int[] vector, int low, int high) {
        if (low < high) {
            int p = partition(vector, low, high);

            sort(vector, low, p-1);
            sort(vector, p+1, high);
        }
    }

    public void sort(int[] vector) {
        sort(vector, 0, vector.length-1);
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] vector, ISortingOrder sorting) {

    }
}

