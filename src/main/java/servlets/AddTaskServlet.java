package servlets;

import entity.Task;
import entity.User;
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

@WebServlet(name = "addTask", urlPatterns = "/addTask")
public class AddTaskServlet extends HttpServlet {

    private TaskService service = new TaskServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addTask.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        Date endDate = null;
        try {
            endDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(req.getParameter("endDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setEndDate(endDate);

        service.addTask(task, user.getId());

        resp.sendRedirect("/tasks");
    }
}
