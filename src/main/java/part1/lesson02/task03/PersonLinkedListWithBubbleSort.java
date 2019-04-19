package part1.lesson02.task03;

import part1.lesson02.task03.exception.DublicatePersonException;
import part1.lesson02.task03.model.PersonNode;

import java.util.LinkedList;

/**
 * Класс реализующий сортировку пузырьковым методом
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class PersonLinkedListWithBubbleSort extends AbstractPersonLinkedList {

    /**
     * Метод сортирует внутренний список с помощью пузырьковой сортировки
     */
    @Override
    public void sort() throws DublicatePersonException {
        PersonNode cursor;
        PersonNode prevCursor;
        for (int i = getSize(); i > 1; i--) {
            cursor = getCursorLastE();
            prevCursor = cursor.getPrev();
            for (int j = i - 1; j > 0; j--) {
                if (cursor.getPerson().compareTo(prevCursor.getPerson()) < 0) {
                    if (cursor == getCursorLastE()) setCursorLastE(prevCursor);
                    cursor.remove();
                    prevCursor.putBefore(cursor);
                    prevCursor = cursor.getPrev();
                } else {
                    cursor = cursor.getPrev();
                    prevCursor = cursor.getPrev();
                }

            }
        }
    }
}
