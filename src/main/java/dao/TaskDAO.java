package dao;

import entity.Task;

import java.util.List;

public interface TaskDAO {

    void create(Task task);

    List<Task> readAll(int userId);

    void update(Task task);

    void delete(int taskId);
}