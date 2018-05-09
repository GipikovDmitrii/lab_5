package dao.Impl;

import dao.DAOException;
import dao.TaskDAO;
import entity.Task;

import org.apache.log4j.Logger;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {

    private static Logger log = Logger.getLogger(TaskDAOImpl.class.getName());

    @Override
    public void create(Task task) {
        log.info("Create new task: " + task.getTitle());
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public Task readById(int id) {
        return null;
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void delete(Task task) {

    }
}
