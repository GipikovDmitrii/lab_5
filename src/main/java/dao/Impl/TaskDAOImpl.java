package dao.Impl;

import dao.DAOFactory;
import dao.TaskDAO;
import entity.Task;

import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {

    private static Logger log = Logger.getLogger(TaskDAOImpl.class.getName());
    private DataSource dataSource = DAOFactory.getInstance().getDataSource();

    @Override
    public void create(Task task) {
        String sql = "INSERT INTO tasks (task_id, title, description, createddate, enddate) VALUES (DEFAULT, (?), (?), (?), (?))";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getCreatedDate().toString());
            statement.setString(4, task.getEndDate().toString());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Task> readAll(int userId) {
        String sql = "SELECT t.task_id, t.title, t.description, t.createddate, t.enddate FROM tasks AS t RIGHT JOIN user_task AS ut ON t.task_id = ut.task_id WHERE user_id = (?);";

        List<Task> tasks = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            result = statement.executeQuery();
            while (result.next()) {
                Task task = new Task(
                        Integer.parseInt(result.getString("task_id")),
                        result.getString("title"),
                        result.getString("description"),
                        result.getDate("createddate"),
                        result.getDate("enddate")
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tasks;
    }

    @Override
    public void update(Task task) {
        String sql = "UPDATE tasks SET title = (?), description = (?) WHERE task_id = (?);";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setInt(3, task.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int taskId) {
        String sql = "DELETE FROM tasks WHERE task_id = (?);";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}