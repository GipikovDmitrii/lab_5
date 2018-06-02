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

@WebServlet(name = "registration", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        if (login.equals("") || password.equals("") || email.equals("")) {
            req.setAttribute("message", "Fill in all fields");
            req.getRequestDispatcher("/registration.jsp").forward(req, resp);

        } else {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setRole(new User.Role(2));

            service.createUser(user);

            resp.sendRedirect("/login");
        }
    }
}
