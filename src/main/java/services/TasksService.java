package services;

import entity.Task;

import java.util.List;

public interface TasksService {

    void addTask(Task task);

    List<Task> getAllTask(int userId);

    void updateTask(Task task);

    void deleteTask(int id);
}