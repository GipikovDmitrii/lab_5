package servlets.servlet;

import entity.Task;
import entity.User;
import services.Impl.TasksServiceImpl;
import services.TasksService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "tasks", urlPatterns = "/tasks")
public class TasksServlet extends HttpServlet {

    private TasksService service = new TasksServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Task> tasks = service.getAllTask(user.getId());
        req.setAttribute("taskList", tasks);
        req.getRequestDispatcher("/tasks.jsp").forward(req, resp);
    }
}
