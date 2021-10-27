package model.dao;

import model.entity.Model;
import model.entity.Order;
import model.entity.Product;
import model.entity.User;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao extends CrudDao<Long, Order> {
    Order getOrderByUserId(Long userId) throws NamingException, SQLException;

    Order getOrderByProductId(Long productId) throws NamingException, SQLException;
}
