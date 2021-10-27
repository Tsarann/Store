package model.dao.impl;

import model.dao.ProductDao;
import model.dao.connection.Connector;
import model.dao.constants.LogInfo;
import model.dao.constants.SQLConstants;
import model.entity.Product;
import model.entity.User;
import model.exception.DataBaseException;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(ProductDaoImpl.class);


    @Override
    public boolean add(Product entity) throws SQLException, NamingException {
        logger.info(LogInfo.ADD + LogInfo.STARTED);

        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQLConstants.INSERT_PRODUCT.getConstant())) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getColor());
            statement.setString(3, entity.getSize());
            statement.setString(4, entity.getCategory());
            statement.setLong(5, entity.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LogInfo.ADD + LogInfo.FAILED, e.getCause());
            return false;
        }
        logger.info(LogInfo.ADD + LogInfo.SUCCESS);
        return true;
    }

    @Override
    public Product getById(Long id) throws NamingException, SQLException {
        logger.info(LogInfo.GET_BY_ID + id + LogInfo.STARTED);
        Product product;
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQLConstants.GET_PRODUCT_BY_ID.getConstant())) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            List<Product> products = initProductList(resultSet);
            if (!products.isEmpty()) {
                product = products.get(0);
            } else {
                logger.warn("Product by id wasn't found. Returning null");
                return null;
            }

        }
        logger.info(LogInfo.GET_BY_ID + id + LogInfo.SUCCESS);
        return product;
    }

    @Override
    public boolean deleteEntity(Long id) throws NamingException {
        logger.info(LogInfo.DELETE + id + LogInfo.STARTED);

        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQLConstants.DELETE_PRODUCT_BY_ID.getConstant())) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LogInfo.DELETE + id + LogInfo.FAILED, e.getCause());
            return false;
        }
        logger.info(LogInfo.DELETE + id + LogInfo.SUCCESS);
        return true;
    }

    @Override
    public boolean updateEntity(Product entity) throws NamingException {
        logger.info(LogInfo.UPDATE + entity + LogInfo.STARTED);
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQLConstants.UPDATE_PRODUCT.getConstant())) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getColor());
            statement.setString(3, entity.getSize());
            statement.setString(4, entity.getCategory());
            statement.setLong(5, entity.getId());
            statement.setLong(6, entity.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LogInfo.UPDATE + entity + LogInfo.FAILED, e.getCause());
            return false;
        }
        logger.info(LogInfo.UPDATE + entity + LogInfo.SUCCESS);
        return true;
    }
    @Override
    public List<Product> getAll() throws NamingException, SQLException {
        logger.info(LogInfo.GET_ALL + LogInfo.STARTED);
        List<Product> products;
        try (Connection connection = Connector.getInstance().getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(SQLConstants.GET_ALL_PRODUCTS.getConstant());
            products = initProductList(rs);

        }
        logger.info(LogInfo.GET_ALL + LogInfo.SUCCESS);
        return products;
    }
    @Override
    public Product getProductByColor(String color) throws NamingException, SQLException {
        logger.info(LogInfo.GET_PRODUCT_BY_COLOR + color + LogInfo.STARTED);
        Product product;

        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQLConstants.SELECT_PRODUCT_BY_COLOR.getConstant())) {

            statement.setString(1, color);
            ResultSet resultSet = statement.executeQuery();

            List<Product> products = initProductList(resultSet);
            if (!products.isEmpty()) {
                product = products.get(0);
            } else {
                logger.warn("Product by color wasn't found. Returning null");
                return null;
            }

        }
        logger.info(LogInfo.GET_PRODUCT_BY_COLOR + product + LogInfo.SUCCESS);
        return product;
    }

    @Override
    public Product getProductBySize(String size) throws NamingException, SQLException {
        logger.info(LogInfo.GET_PRODUCT_BY_SIZE + size + LogInfo.STARTED);
        Product product;

        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQLConstants.SELECT_PRODUCT_BY_SIZE.getConstant())) {

            statement.setString(1, size);
            ResultSet resultSet = statement.executeQuery();

            List<Product> products = initProductList(resultSet);
            if (!products.isEmpty()) {
                product = products.get(0);
            } else {
                logger.warn("Product by size wasn't found. Returning null");
                return null;
            }

        }
        logger.info(LogInfo.GET_PRODUCT_BY_SIZE + product + LogInfo.SUCCESS);
        return product;
    }

    @Override
    public Product getProductByCategory(String category) throws NamingException, SQLException {
        logger.info(LogInfo.GET_PRODUCT_BY_CATEGORY + category + LogInfo.STARTED);
        Product product;

        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQLConstants.SELECT_PRODUCT_BY_CATEGORY.getConstant())) {

            statement.setString(1, category);
            ResultSet resultSet = statement.executeQuery();

            List<Product> products = initProductList(resultSet);
            if (!products.isEmpty()) {
                product = products.get(0);
            } else {
                logger.warn("Product by category wasn't found. Returning null");
                return null;
            }

        }
        logger.info(LogInfo.GET_PRODUCT_BY_CATEGORY + product + LogInfo.SUCCESS);
        return product;
    }
    static List<Product> initProductList(ResultSet rs) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product.ProductBuilderImpl()
                    .setId(rs.getLong(1))
                    .setName(rs.getString(2))
                    .setColor(rs.getString(3))
                    .setSize(rs.getString(4))
                    .setCategory(rs.getString(5))
                    .setPrice(rs.getLong(6))
                    .build();
            products.add(product);
        }
        return products;
    }
}
