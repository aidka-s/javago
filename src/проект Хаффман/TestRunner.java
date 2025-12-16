import java.io.*;
import java.util.*;

// Узел дерева Хаффмана
class HuffmanNode implements Comparable<HuffmanNode> {
    byte data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(byte data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

// Основной класс для кодирования/декодирования Хаффмана
public class TestRunner {
    private Map<Byte, String> huffmanCodes;
    private HuffmanNode root;

    public TestRunner() {
        huffmanCodes = new HashMap<>();
    }

    // Кодирование файла
    public void encode(String inputFile, String outputFile) throws IOException {
        byte[] fileData = readFile(inputFile);
        Map<Byte, Integer> frequencyMap = buildFrequencyMap(fileData);
        root = buildHuffmanTree(frequencyMap);
        generateCodes(root, "");
        String encodedBits = encodeData(fileData);
        byte[] encodedBytes = bitsToBytes(encodedBits);
        writeEncodedFile(outputFile, frequencyMap, encodedBytes, encodedBits.length());
    }

    // Декодирование файла
    public void decode(String inputFile, String outputFile) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(inputFile));

        int mapSize = dis.readInt();
        Map<Byte, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < mapSize; i++) {
            byte b = dis.readByte();
            int freq = dis.readInt();
            frequencyMap.put(b, freq);
        }

        int bitCount = dis.readInt();
        byte[] encodedData = new byte[dis.available()];
        dis.readFully(encodedData);
        dis.close();

        root = buildHuffmanTree(frequencyMap);
        String bitString = bytesToBits(encodedData, bitCount);
        byte[] decodedData = decodeData(bitString);
        writeFile(outputFile, decodedData);
    }

    // Вспомогательные методы
    private byte[] readFile(String filename) throws IOException {
        File file = new File(filename);
        byte[] data = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(data);
        fis.close();
        return data;
    }

    private void writeFile(String filename, byte[] data) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(data);
        fos.close();
    }

    private Map<Byte, Integer> buildFrequencyMap(byte[] data) {
        Map<Byte, Integer> frequencyMap = new HashMap<>();
        for (byte b : data) {
            frequencyMap.put(b, frequencyMap.getOrDefault(b, 0) + 1);
        }
        return frequencyMap;
    }

    private HuffmanNode buildHuffmanTree(Map<Byte, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();

        for (Map.Entry<Byte, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode(left.frequency + right.frequency, left, right);
            pq.offer(parent);
        }

        return pq.poll();
    }

    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) return;

        if (node.isLeaf()) {
            huffmanCodes.put(node.data, code);
        } else {
            generateCodes(node.left, code + "0");
            generateCodes(node.right, code + "1");
        }
    }

    private String encodeData(byte[] data) {
        StringBuilder encoded = new StringBuilder();
        for (byte b : data) {
            encoded.append(huffmanCodes.get(b));
        }
        return encoded.toString();
    }

    private byte[] decodeData(String bitString) {
        List<Byte> decoded = new ArrayList<>();
        HuffmanNode current = root;

        for (char bit : bitString.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.isLeaf()) {
                decoded.add(current.data);
                current = root;
            }
        }

        byte[] result = new byte[decoded.size()];
        for (int i = 0; i < decoded.size(); i++) {
            result[i] = decoded.get(i);
        }
        return result;
    }

    private byte[] bitsToBytes(String bits) {
        int byteCount = (bits.length() + 7) / 8;
        byte[] bytes = new byte[byteCount];

        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == '1') {
                bytes[i / 8] |= (1 << (7 - (i % 8)));
            }
        }

        return bytes;
    }

    private String bytesToBits(byte[] bytes, int bitCount) {
        StringBuilder bits = new StringBuilder();

        for (int i = 0; i < bitCount; i++) {
            int byteIndex = i / 8;
            int bitIndex = 7 - (i % 8);
            boolean isSet = (bytes[byteIndex] & (1 << bitIndex)) != 0;
            bits.append(isSet ? '1' : '0');
        }

        return bits.toString();
    }

    private void writeEncodedFile(String filename, Map<Byte, Integer> frequencyMap,
                                  byte[] encodedData, int bitCount) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename));

        dos.writeInt(frequencyMap.size());
        for (Map.Entry<Byte, Integer> entry : frequencyMap.entrySet()) {
            dos.writeByte(entry.getKey());
            dos.writeInt(entry.getValue());
        }

        dos.writeInt(bitCount);
        dos.write(encodedData);
        dos.close();
    }

    // Метод для создания тестовых файлов
    private static void createTestFiles() throws IOException {
        // Тест 1: 10 одинаковых символов
        try (FileOutputStream fos = new FileOutputStream("test1.txt")) {
            fos.write("1111111111".getBytes());
        }

        // Тест 2: 3 символа с частотами 10, 5, 5
        try (FileOutputStream fos = new FileOutputStream("test2.txt")) {
            fos.write("11111111112222233333".getBytes());
        }

        System.out.println("Созданы тестовые файлы:");
        System.out.println("- test1.txt: 10 символов '1'");
        System.out.println("- test2.txt: 20 символов: 10x'1', 5x'2', 5x'3'");
    }

    // Метод для запуска тестов
    private static void runTests() throws Exception {
        System.out.println("\n=== Тестирование алгоритма Хаффмана ===\n");

        TestRunner coder = new TestRunner();

        // Тест 1: 10 одинаковых символов
        System.out.println("Тест 1: 10 символов '1'");
        testCase(coder, "test1.txt", "test1_encoded.bin", "test1_decoded.txt");

        System.out.println("\n" + "=".repeat(40));

        // Тест 2: 3 символа с частотами 10, 5, 5
        System.out.println("\nТест 2: 20 символов (10x'1', 5x'2', 5x'3')");
        testCase(coder, "test2.txt", "test2_encoded.bin", "test2_decoded.txt");

        System.out.println("\n" + "=".repeat(40));

        // Тест 3: Бинарный файл (сама программа)
        System.out.println("\nТест 3: Бинарный файл (TestRunner.class)");
        if (new File("TestRunner.class").exists()) {
            testCase(coder, "TestRunner.class", "huffman_encoded.bin", "huffman_decoded.class");
        } else {
            System.out.println("Файл TestRunner.class не найден. Скомпилируйте сначала.");
        }
    }

    private static void testCase(TestRunner coder, String input, String encoded, String decoded) throws Exception {
        // Кодирование
        coder.encode(input, encoded);

        // Декодирование
        coder.decode(encoded, decoded);

        // Размеры файлов
        long originalSize = new File(input).length();
        long encodedSize = new File(encoded).length();

        System.out.println("Исходный размер: " + originalSize + " байт");
        System.out.println("Закодированный размер: " + encodedSize + " байт");
        System.out.printf("Коэффициент сжатия: %.2f\n", (double)encodedSize/originalSize);

        // Проверка
        if (compareFiles(input, decoded)) {
            System.out.println("✓ Декодирование корректно");
        } else {
            System.out.println("✗ Ошибка декодирования!");
        }
    }

    private static boolean compareFiles(String file1, String file2) throws Exception {
        byte[] data1 = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(file1));
        byte[] data2 = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(file2));
        return java.util.Arrays.equals(data1, data2);
    }

    // Главный метод
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            // Режим тестирования
            createTestFiles();
            runTests();
        } else if (args.length == 3) {
            // Режим кодирования/декодирования
            String operation = args[0];
            String inputFile = args[1];
            String outputFile = args[2];

            TestRunner coder = new TestRunner();

            try {
                if ("encode".equals(operation)) {
                    coder.encode(inputFile, outputFile);
                    System.out.println("Файл успешно закодирован: " + outputFile);
                } else if ("decode".equals(operation)) {
                    coder.decode(inputFile, outputFile);
                    System.out.println("Файл успешно декодирован: " + outputFile);
                } else {
                    System.out.println("Неизвестная операция: " + operation);
                }
            } catch (IOException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        } else {
            System.out.println("Использование:");
            System.out.println("  Тестирование: java TestRunner");
            System.out.println("  Кодирование: java TestRunner encode <входной_файл> <выходной_файл>");
            System.out.println("  Декодирование: java TestRunner decode <входной_файл> <выходной_файл>");
        }
    }
}