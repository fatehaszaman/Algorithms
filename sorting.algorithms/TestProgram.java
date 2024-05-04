package sorting.algorithms;

public class TestProgram {

    public static String vectorToString(String name, int[] vector) {
        String s = name + " {";

        for (int i = 0; i < vector.length; i++)
            s = s + vector[i] + ((i < vector.length - 1) ? ", " : "");

        s = s + "}";

        return s;
    }

    public static void initializeRandomData(int[] vector) {
        for (int i = 0; i < vector.length; i++)
            vector[i] = (int) (100 * Math.random());
    }

    public static void test(int n) {
        int[] data, random = new int[n];

        initializeRandomData(random);

        System.out.println(vectorToString("\nData             ", random) + "\n");

        // --------------------------------------------------------------------------------------
        // Bubble sort
        // --------------------------------------------------------------------------------------

        ISort bubbleSort = new BubbleSort();

        data = random.clone();
        bubbleSort.sort(data);

        System.out.println(vectorToString("Bubble sort      ", data));

        // --------------------------------------------------------------------------------------
        // Selection sort
        // --------------------------------------------------------------------------------------

        ISort selectionSort = new SelectionSort();

        data = random.clone();
        selectionSort.sort(data);

        System.out.println(vectorToString("Selection sort   ", data));

        // --------------------------------------------------------------------------------------
        // Insertion sort
        // --------------------------------------------------------------------------------------

        ISort insertionSort = new InsertionSort();

        data = random.clone();
        insertionSort.sort(data);

        System.out.println(vectorToString("Insertion sort   ", data));

        // --------------------------------------------------------------------------------------
        // Heap sort
        // --------------------------------------------------------------------------------------

        ISort heapSort = new HeapSort();

        data = random.clone();
        heapSort.sort(data);

        System.out.println(vectorToString("Heap sort        ", data));


    }

    public static void main(String[] args) {
        test(15);
    }
}