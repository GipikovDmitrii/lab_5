package dao.Impl;

import dao.TaskDAO;
import entity.Task;

import entity.User;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {

    private static Logger log = Logger.getLogger(TaskDAOImpl.class.getName());
    private DataSource dataSource;

    public TaskDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(Task task, int userId) {
        String sql = "INSERT INTO tasks (task_id, title, description, createddate, enddate, user_id) VALUES (DEFAULT, (?), (?), current_timestamp, (?), (?));";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setTimestamp(3, new Timestamp(task.getEndDate().getTime()));
            statement.setInt(4, userId);
            statement.execute();
            log.info("User " + userId + " create task");
        } catch (SQLException e) {
            log.error("Failed to create task", e);
        }
    }

    @Override
    public List<Task> readAll(User user) {
        String sql = "SELECT t.task_id, t.title, t.description, t.createddate, t.enddate FROM tasks AS t WHERE user_id = (?);";

        List<Task> tasks = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Task task = new Task(
                        Integer.parseInt(result.getString("task_id")),
                        result.getString("title"),
                        result.getString("description"),
                        result.getTimestamp("createddate"),
                        result.getTimestamp("enddate")
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public Task readById(int taskId) {
        String sql = "SELECT task_id, title, description, createddate, enddate FROM tasks WHERE task_id = (?)";
        Task task = null;

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                task = new Task();
                task.setId(result.getInt("task_id"));
                task.setTitle(result.getString("title"));
                task.setDescription(result.getString("description"));
                task.setCreatedDate(result.getTimestamp("createddate"));
                task.setEndDate(result.getTimestamp("enddate"));
            }
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return task;
    }
    @Override
    public void update(Task task) {
    String sql = "UPDATE tasks SET title = (?), description = (?), enddate = (?) WHERE task_id = (?);";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setTimestamp(3, new Timestamp(task.getEndDate().getTime()));
            statement.setInt(4, task.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int taskId) {
        String sql = "DELETE FROM tasks WHERE task_id = (?);";

        try (Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllTasksUser(User user) {
     String sql = "DELETE FROM tasks WHERE user_id = (?);";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}