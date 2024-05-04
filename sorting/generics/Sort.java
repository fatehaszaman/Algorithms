package sorting.generics;


public abstract class Sort implements ISort {

    protected static <T> void swap(T[] vector, int i, int j) {
        T temp = vector[i];
        vector[i] = vector[j];
        vector[j] = temp;
    }

    @Override
    public abstract <T extends Comparable<T>> void sort(T[] vector, ISortingOrder sorting);

}

