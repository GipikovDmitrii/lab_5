package services.Impl;

import dao.DAOFactory;
import dao.TaskDAO;
import entity.Task;
import services.TasksService;

import java.util.List;

public class TasksServiceImpl implements TasksService {

    private TaskDAO dao = DAOFactory.getInstance().getTaskDao();

    public void addTask(Task task) {
        dao.create(task);
    }

    public List<Task> getAllTask(int userId) {
        return dao.readAll(userId);
    }

    public void updateTask(Task task) {
        dao.update(task);
    }

    public void deleteTask(int taskId) {
        dao.delete(taskId);
    }
}
