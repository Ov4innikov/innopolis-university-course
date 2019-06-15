package part1.lesson22.task01.service;

import part1.lesson22.task01.service.PersonService;
import part1.lesson22.task01.dao.PersonDAO;
import part1.lesson22.task01.dao.jdbc.PersonDAOImpl;
import part1.lesson22.task01.entity.Person;
import part1.lesson22.task01.servlet.AppContextListener;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersonServiceImpl implements PersonService {
    private static final Logger logger = LogManager.getLogger(PersonServiceImpl.class.getName());
    private final PersonDAO personDAO;

    public PersonServiceImpl(Connection con) {
        personDAO = new PersonDAOImpl(con);
    }

    @Override
    public List<Person> getList() {
        return personDAO.getList();
    }

    @Override
    public boolean addPerson(String name, String birth) {
        Person person = new Person();
        person.setName(name);

        Date date = safeParseDate(birth);
        person.setBirthDate(date);
        return personDAO.addPerson(person);
    }

    private Date safeParseDate(String birthStr) {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return format.parse(birthStr);
        } catch (ParseException e) {
            logger.log(Level.SEVERE, "Date parsing error", e);
            throw new RuntimeException(e);
        }
    }

}
