package servlets;

import entity.User;
import services.Impl.UserServiceImpl;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.getUserByLogin(username);

        if (userService.checkExistUser(username, password)) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/tasks");
        } else {
            req.setAttribute("message", "Incorrect username or password.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}