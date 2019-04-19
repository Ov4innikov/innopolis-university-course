package part1.lesson02.task03.model;

import part1.lesson02.task03.exception.DublicatePersonException;

public class Person {

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

    public byte compareTo(Person person) throws DublicatePersonException {
        if (this.equals(person)){
            //throw new DublicatePersonException();
            return 0;
        }
        if ((this.getSex() == Sex.MAN && person.getSex() == Sex.WOMAN) || (this.getAge() > person.getAge() && (this.getSex() == person.getSex())) || (this.getAge() >= person.getAge() && this.getSex() == person.getSex() && this.getName().compareTo(person.getName()) <= -1)) {
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
