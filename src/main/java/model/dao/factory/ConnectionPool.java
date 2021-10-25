package model.dao.factory;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionPool {
    private static Logger logger = Logger.getLogger(ConnectionPool.class);

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        return new ConnectionPool();
    }

    public Connection getConnection() throws SQLException {
        Connection conn;
        String user = null;
        String pass = null;
        String url = null;
        try (InputStream input = new FileInputStream("app.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            user = prop.getProperty("connection.user");
            pass = prop.getProperty("connection.password");
            url = prop.getProperty("connection.url");
        } catch (IOException ex) {
            logger.info(ex);
        }
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }
}
//
//    //private static Logger logger = Logger.getLogger(ConnectionPool.class);
//
//
//    private static ConnectionPool pool;
//    private final DataSource dataSource;
//
//    private ConnectionPool() throws NamingException {
//        Context initialContext = new InitialContext();
//        dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/product");
//
//    }
//
//    public static synchronized ConnectionPool getInstance() throws NamingException {
//
//        if (pool == null) {
//            pool = new ConnectionPool();
//        }
//
//        return pool;
//
//    }
//
//
//    public Connection getConnection() throws SQLException {
//        return dataSource.getConnection();
//
//    }
//
//}
