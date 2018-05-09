package dao;

import entity.User;

public interface UserDAO {

    void create(User user);

    User readByLogin(String login);

    User readById(int id);

    void update(User user);

    void delete(User user);
}
