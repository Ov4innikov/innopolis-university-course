package part1.lesson02.task03;

import org.junit.Assert;
import org.junit.Test;
import part1.lesson02.task03.model.Person;
import part1.lesson02.task03.model.Sex;

public class TestAbstractPersonList {

    @Test
    public void testAddAndGetSize() {
        AbstractPersonLinkedList abstractPersonLinkedList = new PersonLinkedListWithInsertionSort();
        Person personVector[] = new Person[3];
        personVector[0] = new Person(20, Sex.MAN, "Alex");
        personVector[1] = new Person(21, Sex.MAN, "Vova");
        personVector[2] = new Person(25, Sex.WOMAN, "Maria");

        abstractPersonLinkedList.add(personVector[0]);
        abstractPersonLinkedList.add(personVector[1]);
        abstractPersonLinkedList.add(personVector[2]);

        int i = 0;
        for (Person person : abstractPersonLinkedList) {
            Assert.assertEquals(personVector[i], person);
            i++;
        }

        Assert.assertEquals(3, abstractPersonLinkedList.getSize());
    }

    @Test
    public void testRemoveFirstAndGetSize() {
        AbstractPersonLinkedList abstractPersonLinkedList = new PersonLinkedListWithInsertionSort();
        Person personVector[] = new Person[3];
        personVector[0] = new Person(20, Sex.MAN, "Alex");
        personVector[1] = new Person(21, Sex.MAN, "Vova");
        personVector[2] = new Person(25, Sex.WOMAN, "Maria");

        abstractPersonLinkedList.add(personVector[0]);
        abstractPersonLinkedList.add(personVector[1]);
        abstractPersonLinkedList.add(personVector[2]);

        abstractPersonLinkedList.remove(personVector[0]);

        int i = 1;
        for (Person person : abstractPersonLinkedList) {
            Assert.assertEquals(personVector[i], person);
            i++;
        }

        Assert.assertEquals(2, abstractPersonLinkedList.getSize());
    }

    @Test
    public void testRemoveLastAndGetSize() {
        AbstractPersonLinkedList abstractPersonLinkedList = new PersonLinkedListWithInsertionSort();
        Person personVector[] = new Person[3];
        personVector[0] = new Person(20, Sex.MAN, "Alex");
        personVector[1] = new Person(21, Sex.MAN, "Vova");
        personVector[2] = new Person(25, Sex.WOMAN, "Maria");

        abstractPersonLinkedList.add(personVector[0]);
        abstractPersonLinkedList.add(personVector[1]);
        abstractPersonLinkedList.add(personVector[2]);

        abstractPersonLinkedList.remove(personVector[2]);

        int i = 0;
        for (Person person : abstractPersonLinkedList) {
            Assert.assertEquals(personVector[i], person);
            i++;
        }

        Assert.assertEquals(2, abstractPersonLinkedList.getSize());
    }

    @Test
    public void testRemoveMidAndGetSize() {
        AbstractPersonLinkedList abstractPersonLinkedList = new PersonLinkedListWithInsertionSort();
        Person personVector[] = new Person[3];
        personVector[0] = new Person(20, Sex.MAN, "Alex");
        personVector[1] = new Person(21, Sex.MAN, "Vova");
        personVector[2] = new Person(25, Sex.WOMAN, "Maria");

        abstractPersonLinkedList.add(personVector[0]);
        abstractPersonLinkedList.add(personVector[1]);
        abstractPersonLinkedList.add(personVector[2]);

        abstractPersonLinkedList.remove(personVector[1]);
        personVector[1] = personVector[2];

        int i = 0;
        for (Person person : abstractPersonLinkedList) {
            Assert.assertEquals(personVector[i], person);
            i++;
        }

        Assert.assertEquals(2, abstractPersonLinkedList.getSize());
    }
}
