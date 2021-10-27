package model.dao;

import model.entity.Order;
import model.entity.User;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao extends CrudDao<Long, User> {

    List<User> getAll() throws NamingException, SQLException;

    User getUserByName(String name) throws NamingException, SQLException;

    User getUserByEmail(String email) throws NamingException, SQLException;

    List<Order> getAllUserOrders(User user) throws NamingException, SQLException;

}
