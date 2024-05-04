package huffman;

import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCode implements IHuffmanCode {
    private static final char END_OF_INPUT_TEXT = '\00';
    private Map<Character, String> encodingTable;
    private Map<String, Character> decodingTable;
    private boolean verbose;

    public HuffmanCode() {
        this.verbose = false;
    }

    public HuffmanCode(boolean verbose) {
        this.verbose = verbose;
    }

    // encode a string

    @Override
    public String encode(String text) throws Exception {
        text = text + END_OF_INPUT_TEXT;

        createCodingTables(text);

        return bitPadding(encode(text, this.encodingTable));
    }

    // decode a binary string

    @Override
    public String decode(String code) {
        return decode(code, this.decodingTable);
    }

    // encode a string

    private static String encode(String text, Map<Character, String> encodingTable) throws Exception {
        // encode the input string
        StringBuilder encodedText = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (!encodingTable.containsKey(character)) {
                throw new Exception("Character '" + character + "' not found in encoding table.");
            }
            String code = encodingTable.get(character);
            encodedText.append(code);
        }

        return encodedText.toString();
    }

    private static String decode(String code, Map<String, Character> decodingTable) {
        // decode a binary string
        StringBuilder decodedText = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();

        for (char bit : code.toCharArray()) {
            currentCode.append(bit);

            if (decodingTable.containsKey(currentCode.toString())) {
                char symbol = decodingTable.get(currentCode.toString());
                decodedText.append(symbol);
                currentCode.setLength(0);
            }
        }

        return decodedText.toString();
    }

    private void createCodingTables(String text) {
        // 1. create a Huffman's tree from the symbol frequencies of the input string
        // 2. create the encoding table from the Huffman's tree and print the table if verbose is selected
        // 3. create the decoding table from the Huffman's tree and print the table if verbose is selected

        encodingTable = new Hashtable<>();
        decodingTable = new Hashtable<>();

        PriorityQueue<IHuffmanSymbol> symbolFrequencies = countSymbolFrequencies(text);
        IHuffmanSymbol root = createHuffmanTree(symbolFrequencies);

        createEncodingTable(root, "");
        createDecodingTable(root, "");

        if (verbose) {
            System.out.println( encodingTableToString(encodingTable));
            System.out.println( decodingTableToString(decodingTable));
        }
    }


    private void createEncodingTable(IHuffmanSymbol root, String code) {
        // create the encoding table from the Huffman's tree
        if (root instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) root;
            encodingTable.put(leaf.getSymbol(), code);
        } else if (root instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) root;
            createEncodingTable(node.getLeftChild(), code + "0");
            createEncodingTable(node.getRightChild(), code + "1");
        }
    }


    private void createDecodingTable(IHuffmanSymbol root, String code)    {
        // create the decoding table
        if (root instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) root;
            decodingTable.put(code, leaf.getSymbol());
        } else if (root instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) root;
            createDecodingTable(node.getLeftChild(), code + "0");
            createDecodingTable(node.getRightChild(), code + "1");
        }
    }



    // create a priority queue with the Huffman's symbols from the input text

        private static PriorityQueue<IHuffmanSymbol> countSymbolFrequencies(String inputText) {
            char symbol;

            // count the frequencies of the input characters

            Map<Character, Integer> tableOfSymbolFrequencies = new Hashtable<Character, Integer>();

            for (int i=0; i<inputText.length(); i++) {
                symbol = inputText.charAt(i);

                if (tableOfSymbolFrequencies.containsKey(symbol)) {
                    tableOfSymbolFrequencies.put(symbol, tableOfSymbolFrequencies.get(symbol) + 1);
                } else {
                    tableOfSymbolFrequencies.put(symbol, 1);
                }
            }

            // create a priority queue with the symbols and their frequencies

            PriorityQueue<IHuffmanSymbol> symbolFrequencies = new PriorityQueue<IHuffmanSymbol>();

            for (Map.Entry<Character, Integer> charFrequency : tableOfSymbolFrequencies.entrySet()) {
                symbolFrequencies.add(new HuffmanLeaf(charFrequency.getKey(), charFrequency.getValue()));
            }

            return symbolFrequencies;
        }

        // create a Huffman's tree with the symbol frequencies

        private static IHuffmanSymbol createHuffmanTree(PriorityQueue<IHuffmanSymbol> symbolFrequencies) {
            // the Huffman's tree is created by extracting the two smallest frequencies from the priority queue
            // this process ends when the priority queue contains only one symbol
            // the node remaining in the priority queue becomes the root of the Huffman's tree

            IHuffmanSymbol symbol1, symbol2;

            while (symbolFrequencies.size() > 1) {

                // get the first symbol with the smallest frequency

                symbol1 = symbolFrequencies.poll();

                // get the second symbol with the smallest frequency

                symbol2 = symbolFrequencies.poll();

                // add a new node with the sum of the two smallest frequencies to the priority queue

                symbolFrequencies.add(new HuffmanNode(symbol1.getFrequency() + symbol2.getFrequency(), symbol1, symbol2));
            }

            // the node remaining in the priority queue becomes the root of the Huffman's tree

            return symbolFrequencies.poll();
        }

        // append zeros to the last byte of a bit string

        private static String bitPadding(String code) {
            int codeLength = code.length();

            if (codeLength % 8 != 0) {
                int bits = 8 * ((int) (codeLength / 8) + 1) - codeLength;

                code = code + "00000000".substring(0, bits);
            }

            return code;
        }

        // encoding table to String

        private String encodingTableToString(Map<Character, String> encodingTable) {
            String table = "Encoding table \n\n";

            for (Map.Entry<Character, String> entry : encodingTable.entrySet()) {
                if (entry.getKey() >= ' ') {
                    table = table + entry.getKey() + " " + entry.getValue() + "\n";
                }
            }

            return table;
        }

        // decoding table to String

        private String decodingTableToString(Map<String, Character> decodingTable) {
            String table = "Decoding table \n\n";

            for (Map.Entry<String, Character> entry : decodingTable.entrySet()) {
                if (entry.getValue() >= ' ') {
                    table = table + entry.getKey() + " " + entry.getValue() + "\n";
                }
            }

            return table;
        }
    }
