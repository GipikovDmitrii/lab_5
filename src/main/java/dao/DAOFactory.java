package dao;

import dao.Impl.TaskDAOImpl;
import dao.Impl.UserDAOImpl;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOFactory {

    private static DAOFactory factory = new DAOFactory();
    private static DataSource dataSource;

    static {
        setDataSource();
    }

    public static DAOFactory getInstance() {
        return factory;
    }

    private static void setDataSource() {
        try {
            InitialContext context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/task_manager");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public TaskDAO getTaskDao() {
        TaskDAO taskDAO = new TaskDAOImpl(dataSource);
        return taskDAO;
    }

    public UserDAO getUserDao() {
        UserDAO userDAO = new UserDAOImpl(dataSource);
        return userDAO;
    }

    private DAOFactory() {
    }
}