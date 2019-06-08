package part1.lesson06.task02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;

/**
 * Класс для генерации тектовых файлов.
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class TextFileGenerator {

    public static final String[] WORDS_DICTIONARY = new String[]{"dog", "apple", "vine", "computer", "cat"};
    private static final char[] LAST_CHAR_DICTIONARY = new char[]{'.', '!', '?'};
    private static final Random random = new SecureRandom();

    /**
     * Метод генерирует файлы.
     *
     * @param path        - путь
     * @param n           - количество файлов
     * @param size        - размер файлов
     * @param words       - массив слов
     * @param probability - вероятность вхождения слова из words в предложение
     */
    public static void getFiles(String path, int n, int size, String[] words, int probability) throws IOException {
        for (int i = 0; i < n; i++) {
            generteFile(path, size, words, probability);
        }
    }

    /**
     * Метод генерирует файл, текст которого состоит из абзацев.
     *
     * @param path        - путь
     * @param size        - размер файлов в абзацах
     * @param words       - массив слов
     * @param probability - вероятность вхождения слова из words в предложение
     */
    public static void generteFile(String path, int size, String[] words, int probability) throws IOException {
        File file = new File(path + "-" + Instant.now().toEpochMilli());
        System.out.println(file.getName());
        file.createNewFile();
        Writer writer = new FileWriter(file);
        for (int i = 0; i < size; i++) {
            writer.write(generateParagraph(words, probability).toString());
        }
        writer.close();
    }

    /**
     * Метод генерирует абзац, в одном абзаце 1<=n3<=20 предложений.
     * В конце абзаца стоит разрыв строки и перенос каретки.
     *
     * @param words       - массив слов
     * @param probability - вероятность вхождения слова из words в предложение
     */
    private static StringBuilder generateParagraph(String[] words, int probability) {
        StringBuilder paragraph = new StringBuilder();
        int length = random.nextInt(20) + 1;
        for (int i = 0; i < length; i++) {
            paragraph.append(generateProposal(words, probability));
        }
        paragraph.append("\r\n");
        return paragraph;
    }

    /**
     * Метод генерирует предложение, которое состоит из 1<=n1<=15 слов.
     * Cлова разделены одним пробелом.
     * Предложение начинается с заглавной буквы
     * Предложение заканчивается (.|!|?)
     *
     * @param words       - массив слов
     * @param probability - вероятность вхождения слова из words в предложение
     */
    private static StringBuilder generateProposal(String[] words, int probability) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = random.nextInt(14) + 1;
        System.out.println("length = " + length);
        boolean flagOfInsertFromWords = false;
        int indexOfWord = 0;
        if (random.nextInt(99) < probability) flagOfInsertFromWords = true;
        if (flagOfInsertFromWords) indexOfWord = random.nextInt(length);
        StringBuilder newWord;
        for (int i = 0; i < length; i++) {
            if (flagOfInsertFromWords && indexOfWord == i) {
                newWord = new StringBuilder(words[random.nextInt(words.length)]);
            } else {
                newWord = generateWord();
            }
            if (i == 0) {
                newWord.setCharAt(0, Character.toUpperCase(newWord.charAt(0)));
                stringBuilder.append(newWord);
                if (random.nextInt(5) > 3) stringBuilder.append(',');
                stringBuilder.append(' ');
            }
            if (i == length - 1) {
                stringBuilder.append(newWord).append(LAST_CHAR_DICTIONARY[random.nextInt(3)]).append(" ");
            }
            if (i != 0 && i != length - 1){
                stringBuilder.append(newWord);
                if (random.nextInt(5) > 3) stringBuilder.append(',');
                stringBuilder.append(' ');
            }
        }
        return stringBuilder;
    }

    /**
     * Метод генерирует слово, которое состоит из 1<=n2<=15 латинских букв
     */
    private static StringBuilder generateWord() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = random.nextInt(14) + 1;
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) (random.nextInt(26) + 'a'));
        }
        return stringBuilder;
    }
}
