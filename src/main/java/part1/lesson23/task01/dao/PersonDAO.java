package part1.lesson23.task01.dao;

import part1.lesson23.task01.entity.Person;

import java.util.List;

public interface PersonDAO {

    List<Person> getList();

    boolean addPerson(Person person);
}
