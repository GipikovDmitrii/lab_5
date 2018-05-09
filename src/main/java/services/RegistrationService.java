package services;

import dao.Impl.UserDAOImpl;
import dao.UserDAO;
import entity.User;

public class RegistrationService {

    private UserDAO userDAO = new UserDAOImpl();

    public void createUser(User user) {
        userDAO.create(user);
    }

    public User getUserByLogin(String login) {
        return userDAO.readByLogin(login);
    }
}
