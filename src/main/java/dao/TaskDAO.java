package dao;

import entity.Task;
import entity.User;

import java.util.List;

public interface TaskDAO {

    void create(Task task, int userId);

    List<Task> readAll(User user);

    Task readById(int taskId);

    void update(Task task);

    void delete(int taskId);

    void deleteAllTasksUser(User user);
}