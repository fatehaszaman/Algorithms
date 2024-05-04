package sortingcomplexity;


public interface ISort {
    public <T extends Comparable<T>> void sort(T[] vector);

    public void sort(int[] vector);

    public long getCounter();

    class BinarySearchGenerics {

        private static <T> String vectorToString(String text, T[] vector) {
            String s = text + " {";

            for (int i = 0; i < vector.length; i++)
                s = s + vector[i].toString() + ((i < vector.length - 1) ? ", " : "");

            s = s + "}";

            return s;
        }

        private static <T extends Comparable<T>> boolean iterativeBinarySearch(T[] vector, T value) {
            int mid, low = 0, high = vector.length - 1;

            while (low <= high) {
                mid = (low + high) / 2;

                if (vector[mid].compareTo(value) == 0) {
                    return true;

                } else if (vector[mid].compareTo(value) > 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }


        private static <T extends Comparable<T>> boolean recursiveBinarySearch(T[] vector, T value) {


            return recursiveBinarySearch(vector, value, 0, vector.length - 1);
        }

        private static <T extends Comparable<T>> boolean recursiveBinarySearch(T[] vector, T value, int low, int high) {
            if (low > high)
                return false;
            else {
                int mid = (low + high) / 2;

                if (vector[mid].compareTo(value) == 0)
                    return true;
                else if (vector[mid].compareTo(value) > 0)
                    return recursiveBinarySearch(vector, value, low, mid - 1);
                else
                    return recursiveBinarySearch(vector, value, mid + 1, high);
            }
        }
    }
}


