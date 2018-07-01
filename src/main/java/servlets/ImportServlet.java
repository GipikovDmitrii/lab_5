package servlets;

import services.Impl.XMLSessionBeanImpl;
import services.XMLSessionBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(name = "import", urlPatterns = "/tasks/import")
@MultipartConfig
public class ImportServlet extends HttpServlet {

    private XMLSessionBean xmlSessionBean = new XMLSessionBeanImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part filePart = req.getPart("file");
        InputStream fileContent = filePart.getInputStream();

        File file = File.createTempFile("importTasks", "xml");

        try (FileOutputStream out = new FileOutputStream(file)) {
            byte[] buffer = new byte[512];
            int length;
            while ((length = fileContent.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.flush();
        }

        xmlSessionBean.importFile(file);

        resp.sendRedirect("/tasks");
    }
}