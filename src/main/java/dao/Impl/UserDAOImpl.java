package dao.Impl;

import dao.DAOFactory;
import dao.UserDAO;
import entity.User;

import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private static Logger log = Logger.getLogger(TaskDAOImpl.class.getName());
    private DataSource dataSource = DAOFactory.getInstance().getDataSource();

    @Override
    public void create(User user) {
        String sql = "INSERT INTO users (user_id, login, password, role) VALUES (DEFAULT, (?), (?), (?));";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getRole().getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User readByLogin(String login) {
        String sql = "SELECT u.user_id, u.login, u.password, u.role FROM users AS u LEFT JOIN roles AS r ON u.role = r.role_id WHERE u.login = (?);";
        User user = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            result = statement.executeQuery();
            if (result.next()) {
                user = new User();
                user.setId(Integer.parseInt(result.getString("user_id")));
                user.setLogin(result.getString("login"));
                user.setPassword(result.getString("password"));
                user.setRole(new User.Role(result.getInt("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET login = (?), email = (?), password = (?) WHERE user_id = (?);";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(User user) {

    }
}