package sorting.algorithms;

public class BubbleSort extends Sort {

    @Override
    public void sort(int[] vector) {
        for (int i=0; i<vector.length-1; i++)
            for (int j=0; j<vector.length-i-1; j++)
                if(vector[j] > vector[j+1])
                    Sort.swap(vector, j, j+1);
    }

}


