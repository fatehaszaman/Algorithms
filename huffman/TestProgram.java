package huffman;

public class TestProgram {

    public static void main(String[] args) {
        try {

            IHuffmanCode code = new HuffmanCode(true);

            String text = "The most beautiful things in the world cannot be seen or touched, they are felt with the heart.";

            String encodedText = code.encode(text);
            String decodedText = code.decode(encodedText);

            System.out.println("Text '" + text + "'");
            System.out.println("Code '" + encodedText + "'");
            System.out.println("Text '" + decodedText + "' \n");

            System.out.println("The text length in bytes is " + text.length() + ", the code has " + encodedText.length() + " bits and requires only " + encodedText.length()/8 + " bytes! \n");

        } catch (Exception e) {

            System.out.println("Error: " + e.toString());

        }
    }

}