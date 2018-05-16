package dao;

import dao.Impl.TaskDAOImpl;
import dao.Impl.UserDAOImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOFactory {

    private static DAOFactory dbConnection = new DAOFactory();
    private DataSource dataSource;

    public static DAOFactory getInstance() {
        return dbConnection;
    }

    public DataSource getDataSource() {
        Context context = null;
        try {
            context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/task_manager");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    public TaskDAO getTaskDao() {
        TaskDAO taskDAO = new TaskDAOImpl();
        return taskDAO;
    }

    public UserDAO getUserDao() {
        UserDAO userDAO = new UserDAOImpl();
        return userDAO;
    }

    private DAOFactory() {
    }
}