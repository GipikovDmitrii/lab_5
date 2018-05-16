package dao;

import entity.User;

public interface UserDAO {

    void create(User user);

    User readByLogin(String login);

    void update(User user);

    void delete(User user);
}
