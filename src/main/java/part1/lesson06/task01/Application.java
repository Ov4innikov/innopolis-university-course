package part1.lesson06.task01;

import java.io.IOException;
import java.util.Set;

/**
 * Класс для запуска приложения.
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class Application {

    public static void main(String[] args) throws IOException {
        String path = null;
        if (args.length > 0) {
            path = args[0];
        } else {
            path = "File-1556451592179";
        }
        Set<String> stringSet = WordFileReader.readWordsFromFile(path);
        WordFileReader.writeWordsListInFile("List.txt", stringSet);
    }
}
