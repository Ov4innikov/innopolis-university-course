package part1.lesson05.task01;

import part1.lesson05.task01.exception.DublicatePetEcxeption;
import part1.lesson05.task01.model.Pet;

import java.util.*;

/**
 * Класс реализующий картотеку дошних животных
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class PetCardIndex<E extends Pet> {

    private Set<E> pets = new TreeSet<E>(new PetOwnerNameComparator().thenComparing(new PetNameComparator()).thenComparing(new PetWeightComparator()));
    private Map<String, List<E>> petsMap = new HashMap<String, List<E>>();
    private Map<Integer, E> integerEMap = new HashMap<Integer, E>();


    /**
     * Метод добавления домашнего животного в общий список.
     *
     * @param e - домашнее животное
     * @throws DublicatePetEcxeption
     */
    public void add(E e) throws DublicatePetEcxeption {
        if (pets.contains(e)) throw new DublicatePetEcxeption();
        pets.add(e);
        if (petsMap.containsKey(e.getName())) {
            petsMap.get(e.getName()).add(e);
        } else {
            List<E> list = new ArrayList<E>();
            list.add(e);
            petsMap.put(e.getName(), list);
        }
        integerEMap.put(e.getId(), e);
    }

    /**
     * Метод поиска животного по его кличке.
     *
     * @param name - кличка
     * @return E
     */
    public List<E> find(String name) {
        return petsMap.get(name);
    }

    /**
     * Метод изменения данных животного по его идентификатору.
     *
     * @param id     - кличка
     * @param weight - новый вес
     */
    public void update(int id, double weight) {
        integerEMap.get(id).setWeight(weight);
    }

    /**
     * Метод вывод на экран списка животных в отсортированном порядке.
     * Поля для сортировки –  хозяин, кличка животного, вес.
     */
    public void printPets() {
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}
