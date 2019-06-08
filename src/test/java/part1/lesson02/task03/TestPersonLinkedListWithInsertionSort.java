package part1.lesson02.task03;

import org.junit.Assert;
import org.junit.Test;
import part1.lesson02.task03.exception.DublicatePersonException;
import part1.lesson02.task03.model.Person;
import part1.lesson02.task03.model.Sex;

public class TestPersonLinkedListWithInsertionSort {
    
    @Test
    public void testSort1() throws DublicatePersonException {
        AbstractPersonLinkedList abstractPersonLinkedList = new PersonLinkedListWithInsertionSort();
        Person personVector[] = new Person[10];
        personVector[0] = new Person(28, Sex.MAN, "Alex");
        personVector[1] = new Person(21, Sex.MAN, "Vova");
        personVector[2] = new Person(25, Sex.WOMAN, "Maria");
        personVector[3] = new Person(19, Sex.MAN, "Sherlock");
        personVector[4] = new Person(25, Sex.WOMAN, "Lucy");
        personVector[5] = new Person(29, Sex.WOMAN, "Clar");
        personVector[6] = new Person(52, Sex.MAN, "Greg");
        personVector[7] = new Person(33, Sex.MAN, "Tom");
        personVector[8] = new Person(23, Sex.WOMAN, "Natalia");
        personVector[9] = new Person(99, Sex.WOMAN, "Kate");
        for (Person person : personVector) {
            abstractPersonLinkedList.add(person);
        }
        System.out.println("size = " + abstractPersonLinkedList.getSize());
        abstractPersonLinkedList.sort();
        for (Person person : abstractPersonLinkedList) {
            System.out.println(person);
        }
    }

    @Test
    public void testSort2() throws DublicatePersonException {
        AbstractPersonLinkedList abstractPersonLinkedList = new PersonLinkedListWithInsertionSort();
        Person personVector[] = new Person[13];
        personVector[0] = new Person(24, Sex.MAN, "Alex");
        personVector[1] = new Person(21, Sex.MAN, "Vova");
        personVector[2] = new Person(25, Sex.WOMAN, "Maria");
        personVector[3] = new Person(19, Sex.MAN, "Sherlock");
        personVector[4] = new Person(25, Sex.WOMAN, "Lucy");
        personVector[5] = new Person(29, Sex.WOMAN, "Clar");
        personVector[6] = new Person(52, Sex.MAN, "Greg");
        personVector[7] = new Person(33, Sex.MAN, "Tom");
        personVector[8] = new Person(23, Sex.WOMAN, "Natalia");
        personVector[9] = new Person(99, Sex.WOMAN, "Kate");
        personVector[10] = new Person(24, Sex.MAN, "Aba");
        personVector[11] = new Person(101, Sex.WOMAN, "Kate");
        personVector[12] = new Person(99, Sex.WOMAN, "Alina");
        for (Person person : personVector) {
            abstractPersonLinkedList.add(person);
        }
        System.out.println("size = " + abstractPersonLinkedList.getSize());
        abstractPersonLinkedList.sort();
        for (Person person : abstractPersonLinkedList) {
            System.out.println(person);
        }
        Assert.assertEquals(abstractPersonLinkedList.getCursorFirstE().getPerson(), personVector[6]);
        Assert.assertEquals(abstractPersonLinkedList.getCursorLastE().getPerson(), personVector[8]);
    }

    @Test
    public void testSort3() {
        System.out.println("Aba".compareTo("Alex"));
    }
}
