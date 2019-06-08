package part1.lesson02.task03;

import part1.lesson02.task03.exception.DublicatePersonException;
import part1.lesson02.task03.model.Person;
import part1.lesson02.task03.model.PersonNode;
import part1.lesson02.task03.model.Sex;

import java.util.LinkedList;

/**
 * Класс реализующий сортировку методом вставки
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class PersonLinkedListWithInsertionSort extends AbstractPersonLinkedList {

    /**
     * Метод сортирует внутренний список с помощью сортировками вставками
     */
    @Override
    public void sort() throws DublicatePersonException {
        PersonNode nodeCursor = getCursorFirstE();
        while (nodeCursor.hasNext()) {
            PersonNode saveCursor = nodeCursor;
            PersonNode prevCursor = nodeCursor;
            nodeCursor = nodeCursor.getNext();
            Person nodePerson = nodeCursor.getPerson();
            Person prevPerson = prevCursor.getPerson();
            if (((nodePerson.getSex() == Sex.MAN && prevPerson.getSex() == Sex.WOMAN) || (nodePerson.getAge() > prevPerson.getAge() && nodePerson.getSex() == prevPerson.getSex()) || (nodePerson.getAge() >= prevPerson.getAge() && nodePerson.getSex() == prevPerson.getSex() && nodePerson.getName().compareTo(prevPerson.getName()) <= -1))) {
                while (prevCursor.hasPrev() && ((nodePerson.getSex() == Sex.MAN && prevPerson.getSex() == Sex.WOMAN) || (nodePerson.getAge() > prevPerson.getAge() && nodePerson.getSex() == prevPerson.getSex()) || (nodePerson.getAge() >= prevPerson.getAge() && nodePerson.getSex() == prevPerson.getSex() && nodePerson.getName().compareTo(prevPerson.getName()) <= -1))) {
                    prevCursor = prevCursor.getPrev();
                    prevPerson = prevCursor.getPerson();
                    //if ((nodePerson.equals(prevPerson))) throw new DublicatePersonException();
                }
                if (!((nodePerson.getSex() == Sex.MAN && prevPerson.getSex() == Sex.WOMAN) || (nodePerson.getAge() > prevPerson.getAge() && nodePerson.getSex() == prevPerson.getSex()) || (nodePerson.getAge() >= prevPerson.getAge() && nodePerson.getSex() == prevPerson.getSex() && nodePerson.getName().compareTo(prevPerson.getName()) <= -1))) {
                    prevCursor = prevCursor.getNext();
                    prevPerson = prevCursor.getPerson();
                }
                if (!prevCursor.hasPrev() || ((nodePerson.getSex() == Sex.MAN && prevPerson.getSex() == Sex.WOMAN) || (nodePerson.getAge() > prevPerson.getAge() && (nodePerson.getSex() == prevPerson.getSex())) || (nodePerson.getAge() >= prevPerson.getAge() && nodePerson.getSex() == prevPerson.getSex() && nodePerson.getName().compareTo(prevPerson.getName()) <= -1))) {
                    nodeCursor.remove();
                    prevCursor.putBefore(nodeCursor);
                    if (prevCursor == getCursorFirstE()) setCursorFirstE(nodeCursor);
                    nodeCursor = saveCursor;
                }
            }
            if (!nodeCursor.hasNext()) setCursorLastE(nodeCursor);
        }
    }
}