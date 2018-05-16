package servlets.servlet;

import entity.User;
import services.Impl.UserServiceImpl;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "registration", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private UserService service = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        if (login == null || password == null) {
            getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
        }


        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setRole(new User.Role(2));

        service.createUser(user);

        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
