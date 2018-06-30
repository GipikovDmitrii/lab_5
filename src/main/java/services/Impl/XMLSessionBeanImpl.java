package services.Impl;

import dao.DAOFactory;
import dao.TaskDAO;
import entity.User;
import services.XMLSessionBean;

import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

@Stateless
public class XMLSessionBeanImpl implements XMLSessionBean {

    private TaskDAO dao = DAOFactory.getInstance().getTaskDao();

    @Override
    public void importFile(File file) {

    }

    @Override
    public File exportFile(User user) {
        user.setTaskList(dao.readAll(user));
        return buildXmlFile(user);
    }

    private File buildXmlFile(User user) {
        try {
            File file = File.createTempFile("tasks", "xml");
            JAXBContext context = JAXBContext.newInstance(User.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(user, file);
            return file;
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}