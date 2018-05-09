package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection dbConnection = new DBConnection();

    public static DBConnection getInstance() {
        return dbConnection;
    }

    public Connection getConnection() throws SQLException {
        Context context = null;
        DataSource dataSource = null;
        try {
            context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/task_manager");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dataSource.getConnection();
    }

    private DBConnection() {
    }
}

