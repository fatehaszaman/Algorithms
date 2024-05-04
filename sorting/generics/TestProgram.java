package sorting.generics;

public class TestProgram {

    private static <T> String vectorToString(String text, T[] vector) {
        String s = text + " {";

        for (int i=0; i < vector.length; i++)
            s = s + vector[i].toString() + ((i < vector.length - 1) ? ", " : "");

        s = s + "}";

        return s;
    }

    public static void main(String[] args) {

        Integer [] numbers = {3, 11, 1, 5, 9, 10, 15, 25, 2, 8, 7, 13, 6, 4, 30};
        Integer [] arrayOfInteger;

        Double [] decimals = {3.5, 11.0, 1.5, 5.75, 9.0, 10.5, 15.0, 25.5, 2.25, 8.5, 7.0, 13.5, 6.25, 4.0, 30.5};
        Double [] arrayOfDouble;

        System.out.println(vectorToString("Numbers          ", numbers));
        System.out.println(vectorToString("Decimals         ", decimals));

        IPerson [] people = new Person [] { new Person(50, "John", "Smith"), new Person(20, "Jane", "Johnson"),
                new Person(10, "Mary", "White"), new Person(40, "Peter", "Collins"),
                new Person(30, "Julia", "Smith") };
        IPerson [] arrayOfPerson;

        System.out.println(vectorToString("People           ", people) + "\n");

        // Bubble sort

        ISort bubbleSort = new BubbleSort();

        arrayOfInteger = numbers.clone();

        bubbleSort.sort(arrayOfInteger, new AscendingOrder());
        System.out.println(vectorToString("Bubble sort      ", arrayOfInteger));
        bubbleSort.sort(arrayOfInteger, new DescendingOrder());
        System.out.println(vectorToString("Bubble sort      ", arrayOfInteger) + "\n");

        arrayOfDouble = decimals.clone();

        bubbleSort.sort(arrayOfDouble, new AscendingOrder());
        System.out.println(vectorToString("Bubble sort      ", arrayOfDouble));
        bubbleSort.sort(arrayOfDouble, new DescendingOrder());
        System.out.println(vectorToString("Bubble sort      ", arrayOfDouble) + "\n");

        arrayOfPerson = people.clone();

        bubbleSort.sort(arrayOfPerson, new AscendingOrder());
        System.out.println(vectorToString("Bubble sort      ", arrayOfPerson));
        bubbleSort.sort(arrayOfPerson, new DescendingOrder());
        System.out.println(vectorToString("Bubble sort      ", arrayOfPerson) + "\n");

    }

}