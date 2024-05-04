package sortingcomplexity;

public class MergeSort extends Sort {
    private long counter;

    public MergeSort() {
        counter = 0;
    }
    public <T extends Comparable<T>> void sort(T[] vector) {

    }
    public void sort(int[] vector) {
        counter = 0;
        mergeSort(vector, 0, vector.length - 1);
    }

    private void mergeSort(int[] vector, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(vector, left, mid);
            mergeSort(vector, mid + 1, right);

            merge(vector, left, mid, right);
        }
    }

    private void merge(int[] vector, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = vector[left + i];
            counter += 1; // Assignment
        }

        for (int i = 0; i < n2; i++) {
            rightArray[i] = vector[mid + 1 + i];
            counter += 1; // Assignment
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                vector[k] = leftArray[i];
                i++;
            } else {
                vector[k] = rightArray[j];
                j++;
            }
            counter += 2; // Comparisons and Assignment
            k++;
        }

        while (i < n1) {
            vector[k] = leftArray[i];
            i++;
            k++;
            counter += 2; // Comparisons and Assignment
        }

        while (j < n2) {
            vector[k] = rightArray[j];
            j++;
            k++;
            counter += 2; // Comparisons and Assignment
        }
    }


    public long getCounter() {

        return counter;
    }
}
