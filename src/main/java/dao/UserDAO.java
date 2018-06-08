package dao;

import entity.User;

import java.util.List;

public interface UserDAO {

    boolean loginExists(String login);

    boolean emailExists(String email);

    boolean userExists(String login, String password);

    void create(User user);

    List<User> readAll();

    User readByLogin(String login);

    void update(User user);

    void delete(int id);
}
