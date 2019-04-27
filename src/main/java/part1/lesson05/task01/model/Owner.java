package part1.lesson05.task01.model;

import sun.dc.path.PathError;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Класс хозяина домашнего животного
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class Owner implements Comparable<Owner> {

    private String name;
    private int age;
    private Sex sex;
    private Set<Pet> pets = new HashSet<Pet>();

    public void addPet(Pet pet) {
        pets.add(pet);
        if (pet.getOwner() == null) pet.setOwner(this);
    }

    @Override
    public int compareTo(Owner o) {
        if (name.compareTo(o.getName()) < 0) return -10;
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        if (age != owner.age) return false;
        if (!name.equals(owner.name)) return false;
        return sex == owner.sex;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + sex.hashCode();
        return result;
    }
}
