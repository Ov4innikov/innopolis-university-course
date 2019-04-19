package part1.lesson02.task03;

import part1.lesson02.task03.exception.DublicatePersonException;
import part1.lesson02.task03.model.Person;
import part1.lesson02.task03.model.PersonNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс для построения двухсвязаного списка на основе узлов PersonNode
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public abstract class AbstractPersonLinkedList implements Iterable<Person> {

    private PersonNode cursorFirstE;
    private PersonNode cursorLastE;
    private int size;

    /**
     * Метод добавляет эллемент в конец списка
     * @param person - добавляемый Person
     */
    public void add(Person person) {
        if (cursorFirstE == null) cursorFirstE = new PersonNode(person);
        if (cursorLastE == null) {
            cursorLastE = cursorFirstE;
        } else {
            PersonNode node = new PersonNode(person);
            cursorLastE.setNext(node);
            cursorLastE = node;
        }
        size++;
    }

    /**
     * Метод удаляет из спика первый попашийся узел с эллементом идентичным Person
     * @param person - удаляемый Person
     */
    public void remove(Person person) {
        if (cursorFirstE == null) return;
        PersonNode personNode = cursorFirstE;
//        System.out.println("Remove:" + person);
        do {
//            System.out.println(personNode.getPerson());
            if (personNode.getPerson().equals(person)) {
                if (cursorFirstE == personNode) {
                    cursorFirstE = personNode.getNext();
                    personNode.remove();
                    personNode = cursorFirstE;
                    size--;
                    return;
                }
                if (cursorLastE == personNode) {
                    personNode = personNode.getPrev();
                    cursorLastE.remove();
                    cursorLastE = personNode;
                    size--;
                    break;
                }
                personNode.remove();
                size--;
                return;
            }
            personNode = personNode.getNext();
        } while (personNode != null);
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(cursorFirstE);
    }

    public abstract void sort() throws DublicatePersonException;

    public int getSize() {
        return size;
    }

    public Person get(int index) {
        int i = 0;
        if (index > size) throw new IndexOutOfBoundsException();
        for (Person person : this) {
            if (index == i) return person;
        }
        return null;
    }

    private static class PersonIterator implements Iterator<Person> {

        private PersonNode cursorPerson;

        public PersonIterator(PersonNode cursorPerson) {
            this.cursorPerson = cursorPerson;
        }

        @Override
        public boolean hasNext() {
            return cursorPerson != null;
        }

        @Override
        public Person next() {
            Person person = cursorPerson.getPerson();
            cursorPerson = cursorPerson.getNext();
            return person;
        }
    }

    protected PersonNode getCursorFirstE() {
        return cursorFirstE;
    }

    protected void setCursorFirstE(PersonNode cursorFirstE) {
        this.cursorFirstE = cursorFirstE;
    }

    protected PersonNode getCursorLastE() {
        return cursorLastE;
    }

    protected void setCursorLastE(PersonNode cursorLastE) {
        this.cursorLastE = cursorLastE;
    }

    protected void setSize(int size) {
        this.size = size;
    }
}
