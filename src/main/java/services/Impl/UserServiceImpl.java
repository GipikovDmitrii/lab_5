package services.Impl;

import dao.DAOFactory;
import dao.UserDAO;
import entity.User;
import services.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO dao = DAOFactory.getInstance().getUserDao();

    public void createUser(User user) {
        dao.create(user);
    }

    public User getUserByLogin(String login) {
        return dao.readByLogin(login);
    }
}
