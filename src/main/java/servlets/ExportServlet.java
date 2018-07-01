package servlets;

import entity.User;
import services.Impl.XMLSessionBeanImpl;
import services.XMLSessionBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "export", urlPatterns = "/tasks/export")
public class ExportServlet extends HttpServlet {

    private XMLSessionBean xmlSessionBean = new XMLSessionBeanImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        File file = xmlSessionBean.exportFile(user);

        String fileName = "tasks";
        String fileType = "text/xml";

        resp.setContentType(fileType);
        resp.setContentLength((int) file.length());
        resp.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", fileName));

        OutputStream out = resp.getOutputStream();

        try (FileInputStream in = new FileInputStream(file)) {
            byte[] buffer = new byte[512];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.flush();
        }
    }
}