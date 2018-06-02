package services.Impl;

import dao.DAOFactory;
import dao.UserDAO;
import entity.User;
import services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO dao = DAOFactory.getInstance().getUserDao();

    @Override
    public void createUser(User user) {
        dao.create(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return dao.readByLogin(login);
    }

    @Override
    public void deleteUserById(int id) {
        dao.delete(id);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.readAll();
    }
}
