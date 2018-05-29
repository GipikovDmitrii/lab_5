package services.Impl;

import dao.DAOFactory;
import dao.TaskDAO;
import entity.Task;
import entity.User;
import services.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private TaskDAO dao = DAOFactory.getInstance().getTaskDao();

    public void addTask(Task task, int userId) {
        dao.create(task, userId);
    }

    public List<Task> getAllTask(User user) {
        return dao.readAll(user);
    }

    @Override
    public Task getTaskById(int taskId) {
        return dao.readById(taskId);
    }

    public void updateTask(Task task) {
        dao.update(task);
    }

    public void deleteTask(int taskId) {
        dao.delete(taskId);
    }
}
