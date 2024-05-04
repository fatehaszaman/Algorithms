package sorting.generics;

import sorting.generics.ISortingOrder;
import sorting.generics.Sort;
public class BubbleSort extends Sort {

private static long counter;

public BubbleSort() {
        counter=0;
        }


public void sort(int[] vector) {
        counter+=1;  // i=0

        for (int i=0; i<vector.length-1; i++) {
        counter+=1;  // i<this.vector.length - 1
        counter+=1;  // j=0

        for (int j=0; j<vector.length-i-1; j++) {
        counter+=1;  // j<this.vector.length - i - 1
        counter+=1;  // this.vector[j] > this.vector[j+1]

        if (vector[j] > vector[j+1]) {
        Sort.swap(new int[][]{vector}, j+1, j);

        counter+=3;  // 3 assignments to swap values
        }

        counter+=1;  // j++
        }

        counter+=1;  // j<this.vector.length
        counter+=1;  // i++
        }

        counter+=1; // i<this.vector.length
        }


public long getCounter() {
        return counter;
        }

    @Override
    public <T extends Comparable<T>> void sort(T[] vector, ISortingOrder sorting) {

    }
}
   // @Override
   // public <T extends Comparable<T>> void sort(T[] vector, ISortingOrder sorting) {
      //  for (int i = 0; i < vector.length - 1; i++)
       //     for (int j = 0; j < vector.length - i - 1; j++)
        //        if (sorting.compare(vector[j], vector[j + 1]) > 0)
            //        swap(vector, j, j + 1);


