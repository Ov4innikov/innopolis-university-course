package part1.lesson23.task01.service;

import part1.lesson23.task01.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getList();

    boolean addPerson(String name, String birth);
}
