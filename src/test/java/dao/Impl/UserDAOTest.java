package dao.Impl;

import dao.UserDAO;
import entity.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.sql.DataSource;
import java.sql.*;

import static org.mockito.Mockito.*;

public class UserDAOTest {

    private String sql = "INSERT INTO users (user_id, login, email, password, role) VALUES (DEFAULT, (?), (?), (?), (?));";

    private DataSource dataSource = Mockito.mock(DataSource.class);

    private Connection connection = Mockito.mock(Connection.class);

    private PreparedStatement statement = Mockito.mock(PreparedStatement.class);

    private UserDAO userDAO;

    private User user;

    @Before
    public void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        userDAO = new UserDAOImpl(dataSource);
        user = new User(1, "login", "password", "email", new User.Role(1));

        when(dataSource.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(sql)).thenReturn(statement);
    }

    @Test
    public void testCreateUser() throws SQLException {
        userDAO.create(user);

        verify(connection, times(1)).prepareStatement(sql);
        verify(statement, times(1)).setString(1, user.getLogin());
        verify(statement, times(1)).setString(2, user.getEmail());
        verify(statement, times(1)).setString(3, user.getPassword());
        verify(statement, times(1)).setInt(4, user.getRole().getId());
        verify(statement, times(1)).execute();
    }
}