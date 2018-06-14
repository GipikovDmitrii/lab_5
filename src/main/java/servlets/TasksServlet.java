package servlets;

import entity.User;
import services.Impl.TaskServiceImpl;
import services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "tasks", urlPatterns = "/tasks")
public class TasksServlet extends HttpServlet {

    private TaskService service = new TaskServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getUser(req);
        req.setAttribute("taskList", service.getAllTask(user));
        req.getRequestDispatcher("tasks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getUser(req);
        if (req.getParameter("taskId") != null) {
            int taskId = Integer.parseInt(req.getParameter("taskId"));
            service.deleteTask(taskId);
        }
        if (req.getParameter("deleteAll") !=null) {
            service.deleteAllTasks(user);
        }
        req.setAttribute("taskList", service.getAllTask(user));

        req.getRequestDispatcher("/tasks.jsp").forward(req, resp);
    }

    private User getUser(HttpServletRequest req) {
        return (User) req.getSession().getAttribute("user");
    }
}
