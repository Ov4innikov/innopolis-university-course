package part1.lesson05.task01.model;

/**
 * Класс собаки
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class Dog extends Pet {

    public Dog(int id, String name, Owner owner, double weight) {
        super(id, name, owner, weight);
    }

    public Dog(int id, String name, double weight) {
        super(id, name, weight);
    }
}
