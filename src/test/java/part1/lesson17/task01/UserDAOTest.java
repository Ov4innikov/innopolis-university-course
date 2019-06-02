package part1.lesson17.task01;

import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import part1.lesson17.task01.model.User;
import part1.lesson17.task01.ConnectionFactory;
import part1.lesson17.task01.dao.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAOTest {

    private UserDAO userDAOWithMockConnectionFactory;
    private UserDAO userDAOWithSpyConnectionFactory;
    private PreparedStatement preparedStatement;

    @Before
    public void init() throws SQLException {
        ConnectionFactory mockConnectionFactory = mock(ConnectionFactory.class);
        Connection connection = mock(Connection.class);
        preparedStatement = mock(PreparedStatement.class);
        when(preparedStatement.executeUpdate()).thenReturn(1);
        when(connection.prepareStatement(UserDAO.INSERT_INTO_USER)).thenReturn(preparedStatement);
        when(connection.prepareStatement(UserDAO.UPDATE_USER_BY_ID)).thenReturn(preparedStatement);
        when(connection.prepareStatement(UserDAO.DELETE_USER_BY_ID)).thenReturn(preparedStatement);
        when(mockConnectionFactory.getConnect()).thenReturn(connection);
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ConnectionFactory spyConnectionFactory = spy(connectionFactory);
        userDAOWithMockConnectionFactory = new UserDAO(mockConnectionFactory);
        userDAOWithSpyConnectionFactory = spy(new UserDAO(spyConnectionFactory));
    }

    @After
    public void destroy() {
    }

    @Test
    public void checkCreateUser() throws SQLException {
        userDAOWithMockConnectionFactory.insertUser(User.builder().build());
        verify(preparedStatement).executeUpdate();
    }

    @Test
    public void checkReadUser() {
        List<User> actualUsers = userDAOWithSpyConnectionFactory.getUsersByLoginIdAndName(1,"Vadim");
        System.out.println(actualUsers.size());
        verify(userDAOWithSpyConnectionFactory).getUsersByLoginIdAndName(1,"Vadim");
        String expectedUserName = "Vadim";
        Assert.assertEquals(expectedUserName, actualUsers.get(0).getName());
    }

    @Test
    public void checkUpdateUser() throws SQLException {
        userDAOWithMockConnectionFactory.updateUserById(1);
        verify(preparedStatement).executeUpdate();
    }

    @Test
    public void checkDeleteUser() throws SQLException {
        userDAOWithMockConnectionFactory.deleteUserById(1);
        verify(preparedStatement).executeUpdate();
    }
}
