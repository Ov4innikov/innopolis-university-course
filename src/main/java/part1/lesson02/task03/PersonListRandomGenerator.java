package part1.lesson02.task03;

import part1.lesson02.task03.model.Person;
import part1.lesson02.task03.model.Sex;

import java.security.SecureRandom;

public class PersonListRandomGenerator {

    private static SecureRandom secureRandom = new SecureRandom();
    private static String nameManDictionary[] = {"Tom", "Andrey", "Greg", "Eugene", "Alex", "Sherlock", "Anton", "Vasya", "Carl", "Garry"};
    private static String nameWomanDictionary[] = {"Alina", "Lisa", "Lucy", "Anna", "Marry", "Diana", "Galina", "Ira", "Kate", "Kamila", "Angela"};

    public static PersonLinkedListWithInsertionSort generatePersonLinkedListWithInsertionSort(int size) {
        PersonLinkedListWithInsertionSort people = new PersonLinkedListWithInsertionSort();
        for (int i = 0; i < size; i++) {
            byte age = (byte) Math.abs(secureRandom.nextInt() % 100);
            Sex sex = secureRandom.nextInt() > 0 ? Sex.MAN : Sex.WOMAN;
            String name;
            if (sex == Sex.MAN) {
                byte nameIndex = (byte) Math.abs(secureRandom.nextInt() % nameManDictionary.length);
                name = nameManDictionary[nameIndex];
            } else {
                byte nameIndex = (byte) Math.abs(secureRandom.nextInt() % nameWomanDictionary.length);
                name = nameWomanDictionary[nameIndex];
            }
            Person person = new Person(age, sex, name);
            people.add(person);
        }
        return people;
    }

    public static PersonLinkedListWithBubbleSort generatePersonLinkedListWithBubbleSort(int size) {
        PersonLinkedListWithBubbleSort people = new PersonLinkedListWithBubbleSort();
        for (int i = 0; i < size; i++) {
            byte age = (byte) Math.abs(secureRandom.nextInt() % 100);
            Sex sex = secureRandom.nextInt() > 0 ? Sex.MAN : Sex.WOMAN;
            String name;
            if (sex == Sex.MAN) {
                byte nameIndex = (byte) Math.abs(secureRandom.nextInt() % nameManDictionary.length);
                name = nameManDictionary[nameIndex];
            } else {
                byte nameIndex = (byte) Math.abs(secureRandom.nextInt() % nameWomanDictionary.length);
                name = nameWomanDictionary[nameIndex];
            }
            Person person = new Person(age, sex, name);
            people.add(person);
        }
        return people;
    }
}
