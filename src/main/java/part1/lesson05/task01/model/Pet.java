package part1.lesson05.task01.model;

/**
 * Класс домашнего животного
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class Pet implements Comparable<Pet> {

    private int id;
    private String name;
    private Owner owner;
    private double weight;

    public Pet(int id, String name, Owner owner, double weight) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        owner.addPet(this);
        this.weight = weight;
    }

    public Pet(int id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pet o) {
        if (owner.compareTo(o.getOwner()) < 0) {
            return -100;
        } else if (name.compareTo(o.getName()) < 0) {
            return -10;
        } else if (weight < o.getWeight()) {
            return -1;
        }
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        return id == pet.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
