package part1.lesson05.task01.model;

/**
 * Класс домашнего животного
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class Pet {

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

    @Override
    public String toString() {
        return "Pet{" + "id=" + id + ", name='" + name + '\'' + ", owner=" + owner + ", weight=" + weight + '}';
    }
}
