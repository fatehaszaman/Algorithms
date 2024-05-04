package sorting.generics;

public interface ISortingOrder {

    public <T extends Comparable<T>> int compare(T a, T b);

}
