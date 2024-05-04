package sorting.generics;

import sorting.generics.ISortingOrder;

public class DescendingOrder implements ISortingOrder {

    @Override
    public <T extends Comparable<T>> int compare(T a, T b) {
        return b.compareTo(a);
    }

}
