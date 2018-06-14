package servlets;

import entity.Task;
import services.Impl.TaskServiceImpl;
import services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "editTask", urlPatterns = "/tasks/editTask")
public class EditTaskServlet extends HttpServlet {

    private TaskService service = new TaskServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int taskId = Integer.parseInt(req.getParameter("taskId"));
        req.getSession().setAttribute("task", service.getTaskById(taskId));

        req.getRequestDispatcher("/editTask.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        Date endDate = null;
        try {
            endDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(req.getParameter("endDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Task task = (Task) req.getSession().getAttribute("task");
        task.setTitle(title);
        task.setDescription(description);
        task.setEndDate(endDate);

        service.updateTask(task);

        resp.sendRedirect("/tasks");
    }
}
