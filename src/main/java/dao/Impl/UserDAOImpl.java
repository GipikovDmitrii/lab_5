package dao.Impl;

import dao.DBConnection;
import dao.UserDAO;
import entity.User;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private static Logger log = Logger.getLogger(TaskDAOImpl.class.getName());
    private DBConnection dbConnection = DBConnection.getInstance();

    @Override
    public void create(User user) {
        String sql = "INSERT INTO users (user_id, login, password, role) VALUES (DEFAULT, (?), (?), (?));";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dbConnection.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
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
        String sql = "SELECT u.user_id, u.login, u.password, r.id AS role_id, r.role FROM users AS u LEFT JOIN roles AS r ON u.role = r.id WHERE u.login = (?);";
        User user = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = dbConnection.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            result = statement.executeQuery();
            if (result.next()) {
                user = new User();
                user.setId(Integer.parseInt(result.getString("user_id")));
                user.setUsername(result.getString("login"));
                user.setPassword(result.getString("password"));
                user.setRole(new User.Role(result.getInt("role_id"), result.getString("role")));
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
    public User readById(int id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}