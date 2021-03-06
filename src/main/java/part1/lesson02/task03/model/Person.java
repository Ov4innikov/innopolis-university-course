package part1.lesson02.task03.model;

import part1.lesson02.task03.exception.DublicatePersonException;

/**
 * Person
 *
 * @version 1.0.0
 * @autor Овчинников Евгений
 */
public class Person implements Comparable<Person> {

    private int age;
    private Sex sex;
    private String name;

    public Person(int age, Sex sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Функция сравнивает this и person, и если this должен идти раньше person, то возвращает отрицательное число
     *
     * @param person - Person
     * @return 1 или 0 или -1
     */
    @Override
    public int compareTo(Person person) {
        if (this.equals(person)) {
            //throw new DublicatePersonException();
            return 0;
        }
        if ((this.getSex() == Sex.MAN && person.getSex() == Sex.WOMAN)) {
            return -1;
        } else if ((this.getAge() > person.getAge() && (this.getSex() == person.getSex()))) {
            return -1;
        } else if((this.getAge() >= person.getAge() && this.getSex() == person.getSex() && this.getName().compareTo(person.getName()) <= -1)) {
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (sex != person.sex) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = (int) age;
        result = 31 * result + sex.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", sex=" + sex + ", name='" + name + '\'' + '}';
    }
}
