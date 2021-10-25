package model.dao.impl;

import model.entity.User;
import model.exception.DataBaseException;

import javax.naming.NamingException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, NamingException, DataBaseException {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        User user = new User();
        user.setfName("Ilya");
        user.setEmail("Ilya@gmail.com");
        user.setPassword("987654");
        user.setAccessLevel("USER");
        userDaoImpl.add(user);
    }
}
