package services;

import entity.User;

public interface UserService {

    void createUser(User user);

    User getUserByLogin(String login);


}
