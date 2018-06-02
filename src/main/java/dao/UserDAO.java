package dao;

import entity.User;

import java.util.List;

public interface UserDAO {

    void create(User user);

    List<User> readAll();

    User readByLogin(String login);

    void update(User user);

    void delete(int id);
}
