package part1.lesson23.task01.dao.jdbc;

import part1.lesson23.task01.dao.PersonDAO;
import part1.lesson23.task01.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * JDBC реализация PersonDAO.
 *
 * @autor Овчинников Евгений
 */
public class PersonDAOImpl implements PersonDAO {
    private static final Logger logger = LogManager.getLogger(PersonDAOImpl.class.getName());
    private final Connection connection;

    public PersonDAOImpl(Connection con) {
        this.connection = con;
    }

    private static final String INSERT_PERSON_SQL_TEMPLATE =
            "insert into person (name, birth_date) values (?, ?)";
    private static final String SELECT_PERSON_SQL_TEMPLATE =
            "select id, name, birth_date from person";

    @Override
    public List<Person> getList() {
        List<Person> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_PERSON_SQL_TEMPLATE)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt(1));
                    person.setName(resultSet.getString(2));
                    person.setBirthDate(resultSet.getDate(3));
                    result.add(person);
                }
            }

        } catch (SQLException e) {
            logger.error("An exception occurred on the DAO layer.", e);
        }
        return result;
    }

    @Override
    public boolean addPerson(Person person) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_PERSON_SQL_TEMPLATE)) {
            statement.setString(1, person.getName());
            if (person.getBirthDate() == null) {
                statement.setNull(2, Types.BIGINT);
            } else {
                statement.setDate(2, new Date(person.getBirthDate().getTime()));
            }
            statement.execute();
            return true;
        } catch (SQLException e) {
            logger.error("An exception occurred on the DAO layer.", e);
            return false;
        }
    }
}
