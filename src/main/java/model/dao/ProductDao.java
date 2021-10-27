package model.dao;

import model.entity.Order;
import model.entity.Product;
import model.entity.User;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface ProductDao extends CrudDao<Long, Product> {

    List<Product> getAll() throws NamingException, SQLException;

    Product getProductByColor(String color) throws NamingException, SQLException;

    Product getProductBySize(String size) throws NamingException, SQLException;

    Product getProductByCategory(String size) throws NamingException, SQLException;



}
