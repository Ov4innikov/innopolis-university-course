package part1.lesson15.task01.dao;

import part1.lesson15.task01.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Овчинников Евгений
 */
public class UserDAO {

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

    private static final String INSERT_INTO_USER = "insert into lesson15.\"USER\" values (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_USERS_BY_LOGINID_AND_NAME = "select * from lesson15.\"USER\" where login_id = ? and name = ?";

    public UserDAO() throws ClassNotFoundException {
        //Class.forName("org.postgresql.Driver");
    }

    /**
     * Вставить пользователя. Пункт задания 2.a.
     * @param user
     */
    public void insertUser(User user) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_USER);) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setDate(3, user.getBirthday());
            preparedStatement.setInt(4, user.getLoginId());
            preparedStatement.setString(5, user.getCity());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Выполнить batch вставку. Пункт задания 2.b.
     */
    public void insertFixedUsersByBatch() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD); Statement statement = connection.createStatement();) {
            statement.addBatch("insert into lesson15.\"USER\" values (5, 'Garry', '21/03/2018', 5, 'Moscow', 'garry@mail.ru', 'user 5')");
            statement.addBatch("insert into lesson15.\"USER\" values (6, 'Petr', '13/05/2018', 5, 'Sochi', 'petr@mail.ru', 'user 6')");
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получить пользователей по login_id и по name. Пункт задания 3.
     * @param loginId
     * @param name
     * @return
     */
    public List<User> getUsersByLoginIdAndName(int loginId, String name) {
        List<User> users = new ArrayList<User>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_LOGINID_AND_NAME);) {
            ResultSet resultSet = null;
            preparedStatement.setInt(1, loginId);
            preparedStatement.setString(2, name);
            try {
                User user;
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    user = User.builder().id(resultSet.getInt(0)).name(resultSet.getString(1)).birthday(resultSet.getDate(2)).loginId(resultSet.getInt(3)).city(resultSet.getString(4)).email(resultSet.getString(5)).description(resultSet.getString(6)).build();
                    users.add(user);
                }
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    /**
     * Встака пользователей в ручном режиме управления транзакциями с применением savepoint. Пункт задания 4.a.
     */
    public void insertFixDataWithFalseAutoCommitAndSetSavePointOk() {
        Savepoint savepoint = null;
        //PSQLSavepoint
        Connection con = null;
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD); Statement statement = connection.createStatement();) {
            con = connection;
            connection.setAutoCommit(false);
            statement.execute("insert into lesson15.\"USER\" values (6, 'Lucy', '21/03/2016', 6, 'Moscow', 'lucy@mail.ru', 'user 6')");
            statement.execute("insert into lesson15.\"USER\" values (7, 'Lucy', '12/03/2016', 7, 'Novgorod', 'lucy@mail.ru', 'user 7')");
            savepoint = connection.setSavepoint();
            statement.execute("insert into lesson15.\"USER_ROLE\" values (5, 6, 2)");
            statement.execute("insert into lesson15.\"USER_ROLE\" values (5, 7, 2)");
            connection.commit();
        } catch (SQLException e) {
            try {
                if (savepoint == null && con != null) {
                    con.rollback();
                    System.out.println("JDBC Transaction rolled back successfully");
                } else if (con != null){
                    con.commit();
                }
            } catch (SQLException e1) {
                System.out.println("SQLException in rollback" + e1.getMessage());
            }
            e.printStackTrace();
        }
    }

    /**
     * Встака пользователей в ручном режиме управления транзакциями с применением savepoint и с намеренным откатом к нему. Пункт задания 4.b.
     */
    public void insertFixDataWithFalseAutoCommitAndSetSavePointError() {
        Savepoint savepoint = null;
        Connection con = null;
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD); Statement statement = connection.createStatement();) {
            con = connection;
            connection.setAutoCommit(false);
            statement.execute("insert into lesson15.\"USER\" values (6, 'Lucy', '21/03/2016', 6, 'Moscow', 'lucy@mail.ru', 'user 6'");
            statement.execute("insert into lesson15.\"USER\" values (7, 'Lucy', '12/03/2016', 7, 'Novgorod', 'lucy@mail.ru', 'user 7'");
            savepoint = connection.setSavepoint();
            statement.execute("insert into lesson15 values (5, 6, 2)");
            statement.execute("insert into lesson15 values (5, 7, 2)");
            connection.commit();
        } catch (SQLException e) {
            try {
                if (savepoint == null && con != null) {
                    con.rollback();
                    System.out.println("JDBC Transaction rolled back successfully");
                } else if (con != null){
                    con.commit();
                }
            } catch (SQLException e1) {
                System.out.println("SQLException in rollback" + e1.getMessage());
            }
            e.printStackTrace();
        }
    }
}