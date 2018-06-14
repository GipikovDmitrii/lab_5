package services;

import entity.Task;
import entity.User;

import java.util.List;

public interface TaskService {

    void addTask(Task task, int userId);

    List<Task> getAllTask(User user);

    Task getTaskById(int taskId);

    void updateTask(Task task);

    void deleteTask(int taskId);

    void deleteAllTasks(User user);
}