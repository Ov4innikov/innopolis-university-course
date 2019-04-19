package part1.lesson02.task03;

import org.junit.Assert;
import org.junit.Test;
import part1.lesson02.task03.exception.DublicatePersonException;
import part1.lesson02.task03.model.Person;

public class TestPersonListRandomGenerator {

    @Test
    public void testGeneratePersonLinkedListWithInsertionSort() throws DublicatePersonException {
        PersonLinkedListWithInsertionSort people = PersonListRandomGenerator.generatePersonLinkedListWithInsertionSort(100);
        for (Person person : people) {
            System.out.println(person);
        }
        System.out.println("--------------------------------------------");
        people.sort();
        for (Person person : people) {
            System.out.println(person);
        }
        Assert.assertEquals(100,people.getSize());
    }

    @Test
    public void testGeneratePersonLinkedListWithBubbleSort() throws DublicatePersonException {
        PersonLinkedListWithBubbleSort people = PersonListRandomGenerator.generatePersonLinkedListWithBubbleSort(100);
        for (Person person : people) {
            System.out.println(person);
        }
        System.out.println("--------------------------------------------");
        people.sort();
        for (Person person : people) {
            System.out.println(person);
        }
        Assert.assertEquals(100,people.getSize());
    }
}
