package services.Impl;

import dao.DAOFactory;
import dao.TaskDAO;
import entity.User;
import org.xml.sax.SAXException;
import services.XMLSessionBean;

import javax.ejb.Stateless;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

@Stateless
public class XMLSessionBeanImpl implements XMLSessionBean {

    private TaskDAO dao = DAOFactory.getInstance().getTaskDao();

    @Override
    public void importFile(File file) {
        User user = parseXmlFile(file);
        dao.createTasks(user.getTaskList(), user.getId());
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
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(user, file);
            return file;
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User parseXmlFile(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("C:\\Users\\Dm\\IdeaProjects\\lab_5\\src\\resources\\user_tasks.xsd"));
            unmarshaller.setSchema(schema);
            User user = (User) unmarshaller.unmarshal(file);
            return user;
        } catch (JAXBException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
}