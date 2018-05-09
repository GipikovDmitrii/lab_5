package dao;

import entity.Task;

import java.util.List;

public interface TaskDAO {

    void create(Task task);

    List<Task> getAll();

    Task readById(int id);

    void update(Task task);

    void delete(Task task);
}
