package servlets;

import services.Impl.XMLSessionBeanImpl;
import services.XMLSessionBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "import", urlPatterns = "/tasks/import")
public class ImportServlet extends HttpServlet {

    private XMLSessionBean xmlSessionBean = new XMLSessionBeanImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        File file = new File(req.getParameter("file"));

        xmlSessionBean.importFile(file);

        resp.sendRedirect("/tasks");
    }
}