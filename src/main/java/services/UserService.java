package services;

import entity.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User getUserByLogin(String login);

    void deleteUserById(int id);

    List<User> getAllUsers();
}
