package services;

import entity.User;

import java.io.File;

public interface XMLSessionBean {

    void importFile(File file);

    File exportFile(User user);

}
