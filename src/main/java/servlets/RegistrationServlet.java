package servlets;

import entity.User;
import services.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String password = req.getParameter("password");

        RegistrationService service = new RegistrationService();
        User user = new User();
        user.setUsername(login);
        user.setPassword(password);
        user.setRole(new User.Role(1, "user"));

        service.createUser(user);

        getServletContext().getRequestDispatcher("/tasks.jsp").forward(req, resp);
    }
}
