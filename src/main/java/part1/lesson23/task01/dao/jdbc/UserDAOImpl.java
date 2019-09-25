package part1.lesson23.task01.dao.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import part1.lesson23.task01.dao.UserDAO;
import part1.lesson23.task01.entity.Role;
import part1.lesson23.task01.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

/**
 * JDBC реализация UserDAO.
 *
 * @autor Овчинников Евгений
 */
public class UserDAOImpl implements UserDAO {

    private RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("password"), Role.valueOf(resultSet.getString("role")));
    };

    private JdbcTemplate jdbcTemplate;

    public UserDAOImpl(Connection connection) {
        jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(connection, false));
    }

    public User getById(int id) {
        List<User> users =  jdbcTemplate.query("SELECT * FROM user WHERE id = ?", new Object[]{id}, ROW_MAPPER);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    public User getUserByLogin(final String login) {
        List<User> users = jdbcTemplate.query("SELECT * FROM user WHERE login = ?", new Object[]{login}, ROW_MAPPER);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    public boolean loginAndPasswordIsTrue(final String login, final String password) {
        List<User> users = jdbcTemplate.query("SELECT * FROM user WHERE login = ?1 and password = ?2", new Object[]{login, password}, ROW_MAPPER);
        if (users.size() > 0) {
            return true;
        }
        return false;
    }
}