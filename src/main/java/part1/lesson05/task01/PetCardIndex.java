package part1.lesson05.task01;

import part1.lesson05.task01.model.Pet;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс реализующий картотеку дошних животных
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class PetCardIndex<E extends Pet> {

    private Map<Integer, E> pets = new TreeMap<Integer, E>();

    /**
     * Метод добавления домашнего животного в общий список.
     * @param e - домашнее животное
     */
    public void add(E e) {

    }

    /**
     * Метод поиска животного по его кличке.
     * @param name - кличка
     * @return E
     */
    public E find(String name) {

    }

    /**
     * Метод изменения данных животного по его идентификатору.
     * @param id - кличка
     */
    public void update(int id) {

    }

    /**
     * Метод вывод на экран списка животных в отсортированном порядке.
     * Поля для сортировки –  хозяин, кличка животного, вес.
     */
    public void printPets() {

    }
}
