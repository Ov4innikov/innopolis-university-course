package part1.lesson06.task01;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс для чтения слов из файла и записи их в файл.
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class WordFileReader {

    /**
     * Метод читает слова из файла и записывает в множество.
     *
     * @param path - путь к файлу для чтения
     * @return множество слов
     */
    public static Set<String> readWordsFromFile(String path) throws IOException {
        Set<String> stringSet = new TreeSet<String>(new WordComparator());
        File file = new File(path);
        try (Reader reader = new FileReader(file)) {
            int intChar = reader.read();
            StringBuilder word = new StringBuilder();
            while (intChar != -1) {
                if ((char) intChar != '.' && (char) intChar != ',' && (char) intChar != '!' && (char) intChar != '?' && (char) intChar != ' ' && (char) intChar != '\n' && (char) intChar != '\r') {
                    word.append((char) intChar);
                } else {
                    if (word.length() != 0) {
                        stringSet.add(word.toString().toLowerCase().intern());
                        word = new StringBuilder();
                    }
                }
                intChar = reader.read();
            }
        }
        return stringSet;
    }

    /**
     * Метод записывает в файл слова, каждое с новой строки, в отсортированом порядке.
     *
     * @param path      - путь к файлу для записи
     * @param stringSet - множество слов
     */
    public static void writeWordsListInFile(String path, Set<String> stringSet) throws IOException {
        File file = new File(path);
        file.createNewFile();
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String string : stringSet) {
                fileWriter.write(string);
                fileWriter.write("\r\n");
            }
        }
    }

}
