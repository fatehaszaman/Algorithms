package sorting.algorithms;

public class HeapSort extends Sort {

    @Override
    public void sort(int[] vector) {

        /*
         * 1. Transform the input array into a max heap using the function heapify
         *
         * 2. Swap the maximum value at the root node with the last element in the heap
         *
         * 3. Shift down the value at the root to restore the max heap property
         *
         * 4. Repeat steps 2 and 3 until the array is sorted, excluding the last element from the heap on each iteration
         */

        int n = vector.length-1;

        for (int i=vector.length/2 - 1; i>=0; i--)
            heapify(vector, i);

        while (n > 0) {
            swap(vector, 0, n--);
            shiftDown(vector, 0, n);
        }
    }

    private static void heapify(int[] vector, int parent) {
        int left = 2*parent + 1;
        int right = 2*parent + 2;
        int maximum = parent;

        // heapify rearranges the items of the array to satisfy the heap property, it
        // swaps the value of the parent node with the maximum value of its children
        // leaf nodes have left and right children greater than vector.length
        if (left < vector.length && vector[left] > vector[maximum]) maximum = left;
        if (right < vector.length && vector[right] > vector[maximum]) maximum = right;
        if (maximum != parent) { swap(vector, maximum, parent); heapify(vector, maximum);
        }
    }

    private void shiftDown(int[] vector, int parent, int last) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        if (left <= last) {
            if (right <= last) {
                if (vector[left] > vector[right]) {
                    if (vector[parent] < vector[left]) {
                        swap(vector, parent, left);
                        shiftDown(vector, left, last);
                    }
                }

                else {
                    if (vector[parent] < vector[right]) {
                        swap(vector, parent, right);
                        shiftDown(vector, right, last);
                    }
                }
            } else {
                if (vector[parent] < vector[left]) {
                    swap(vector, parent, left);
                    shiftDown(vector, left, last);
                }
            }
        }
    }

    public static void swap(int[] vector, int i, int j) {
        int temp = vector[i];
        vector[i] = vector[j];
        vector[j] = temp;


        }
    }


