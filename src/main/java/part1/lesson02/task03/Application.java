package part1.lesson02.task03;

import part1.lesson02.task03.exception.DublicatePersonException;
import part1.lesson02.task03.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) throws DublicatePersonException {
        List<Number> number = Arrays.<Number>asList(11);
        System.out.println("--------------------------------------------");
        long start = System.currentTimeMillis();
        PersonLinkedListWithInsertionSort people1 = PersonListRandomGenerator.generatePersonLinkedListWithInsertionSort(100);
        people1.sort();
        for (Person person : people1) {
            System.out.println(person);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (finish - start) + "ms");

        System.out.println("--------------------------------------------");
        start = System.currentTimeMillis();
        PersonLinkedListWithBubbleSort people2 = PersonListRandomGenerator.generatePersonLinkedListWithBubbleSort(100);
        people2.sort();
        for (Person person : people2) {
            System.out.println(person);
        }
        finish = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (finish - start) + "ms");
    }
}
