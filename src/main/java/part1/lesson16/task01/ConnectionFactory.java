package part1.lesson16.task01;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Фабрика подключения к базе данных.
 * @author Овчинников Евгений
 */
public class ConnectionFactory {

    private static final BasicDataSource dataSource;

    /**
     * JDBC Driver and database url
     */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://127.0.0.1:5432/postgres";

    /**
     * User and Password
     */
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl(DATABASE_URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
    }

    public ConnectionFactory() {}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}