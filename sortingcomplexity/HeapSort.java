package sortingcomplexity;

public class HeapSort implements ISort {
    private long counter;

    public HeapSort() {
        counter = 0;
    }
    public <T extends Comparable<T>> void sort(T[] vector) {

    }
    public void sort(int[] vector) {
        int n = vector.length - 1;

        for (int i = vector.length / 2 - 1; i >= 0; i--) {
            heapify(vector, i);
        }

        while (n > 0) {
            swap(vector, 0, n--);
            shiftDown(vector, 0, n);
        }
    }

    public long getCounter() {
        return counter;
    }

    private void heapify(int[] vector, int parent) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int maximum = parent;

        if (left < vector.length) {
            counter += 1; // Increment for left comparison
            if (vector[left] > vector[maximum]) {
                maximum = left;
                counter += 1; // Increment for swap condition
            }
        }
        if (right < vector.length) {
            counter += 1; // Increment for right comparison
            if (vector[right] > vector[maximum]) {
                maximum = right;
                counter += 1; // Increment for swap condition
            }
        }

        if (maximum != parent) {
            swap(vector, maximum, parent);
            counter += 3; // Increment for 3 assignments
            heapify(vector, maximum);
        }
    }

    private void shiftDown(int[] vector, int parent, int last) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        if (left <= last) {
            counter += 1; // Increment for left comparison
            if (right <= last) {
                counter += 1; // Increment for right comparison
                if (vector[left] > vector[right]) {
                    if (vector[parent] < vector[left]) {
                        swap(vector, parent, left);
                        counter += 3; // Increment for 3 assignments
                        shiftDown(vector, left, last);
                    } else {
                        if (vector[parent] < vector[right]) {
                            swap(vector, parent, right);
                            counter += 3; // Increment for 3 assignments
                            shiftDown(vector, right, last);
                        }
                    }
                } else {
                    if (vector[parent] < vector[right]) {
                        swap(vector, parent, right);
                        counter += 3; // Increment for 3 assignments
                        shiftDown(vector, right, last);
                    }
                }
            } else {
                if (vector[parent] < vector[left]) {
                    swap(vector, parent, left);
                    counter += 3; // Increment for 3 assignments
                    shiftDown(vector, left, last);
                }
            }
        }
    }

    private void swap(int[] vector, int i, int j) {
        int temp = vector[i];
        vector[i] = vector[j];
        vector[j] = temp;
        counter += 3; // Increment for 3 assignments
    }
}
