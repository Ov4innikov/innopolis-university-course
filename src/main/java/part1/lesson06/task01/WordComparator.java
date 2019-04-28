package part1.lesson06.task01;

import java.util.Comparator;

/**
 * Класс для сортировки слов.
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class WordComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
