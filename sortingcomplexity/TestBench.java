package sortingcomplexity;
import java.util.Arrays;
import java.util.Random;

public class TestBench extends LomutoQuickSort {
    public static void main(String[] args) {
        int[] inputSizes = {1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072};

        for (int size : inputSizes) {
            int[] randomVector = generateRandomVector(size);
            int[] sortedVector = generateSortedVector(size);

            ISort[] sortingAlgorithms = {
                    new BubbleSort(),
                    new OptimizedBubbleSort(),
                    new InsertionSort(),
                    new SelectionSort(),
                    new HeapSort(),
                    new HoareQuicksort(),
                    new MergeSort(),
                    new LomutoQuickSort()
            };

            System.out.println("Performance on Random Input - Size " + size + "\n");

            for (ISort algorithm : sortingAlgorithms) {
                long startTime = System.nanoTime();
                algorithm.sort(Arrays.copyOf(randomVector, randomVector.length)); // Copy the array to avoid sorting in-place
                long endTime = System.nanoTime();
                long elapsedTime = endTime - startTime;
                long elementaryInstructions = algorithm.getCounter();

                System.out.println(algorithm.getClass().getSimpleName());
                System.out.println("Time elapsed: " + elapsedTime + " nanoseconds");
                System.out.println("Elementary Instructions: " + elementaryInstructions);
                System.out.println();
            }
        }
    }

    private static int[] generateRandomVector(int size) {
        int[] randomVector = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            randomVector[i] = random.nextInt(100); // Generate random values between 0 and 99
        }
        return randomVector;
    }

    private static int[] generateSortedVector(int size) {
        int[] sortedVector = new int[size];
        for (int i = 0; i < size; i++) {
            sortedVector[i] = i + 1; // Generate a sorted vector from 1 to size
        }
        return sortedVector;
    }
}
