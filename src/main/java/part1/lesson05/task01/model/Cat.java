package part1.lesson05.task01.model;

/**
 * Класс кота
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class Cat extends Pet {

    public Cat(int id, String name, Owner owner, double weight) {
        super(id, name, owner, weight);
    }

    public Cat(int id, String name, double weight) {
        super(id, name, weight);
    }
}
