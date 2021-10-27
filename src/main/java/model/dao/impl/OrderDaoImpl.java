package model.dao.impl;

import model.dao.OrderDao;
import model.dao.connection.Connector;
import model.dao.constants.LogInfo;
import model.dao.constants.SQLConstants;
import model.entity.Order;
import model.entity.User;
import org.apache.log4j.Logger;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(OrderDaoImpl.class);

    @Override
    public boolean add(Order entity) throws SQLException, NamingException {
        return false;
    }

    @Override
    public Order getById(Long id) throws NamingException, SQLException  {
        logger.info(LogInfo.GET_BY_ID + id + LogInfo.STARTED);
        Order order;
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQLConstants.GET_ORDER_BY_ID.getConstant())) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            List<Order> orders= initOrderList(resultSet);
            if (!orders.isEmpty()) {
                order = orders.get(0);
            } else {
                logger.warn("Order by id wasn't found. Returning null");
                return null;
            }

        }
        logger.info(LogInfo.GET_BY_ID + id + LogInfo.SUCCESS);
        return order;
    }

    @Override
    public boolean deleteEntity(Long id) throws NamingException {
        logger.info(LogInfo.DELETE + id + LogInfo.STARTED);

        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQLConstants.DELETE_ORDER_BY_ID.getConstant())) {
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
    public boolean updateEntity(Order entity) throws NamingException {
        logger.info(LogInfo.UPDATE + entity + LogInfo.STARTED);
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQLConstants.UPDATE_PRODUCT.getConstant())) {
            statement.setLong(1, entity.getId());
            statement.setLong(2, entity.getUserId());
            statement.setLong(3, entity.getProductId());

            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LogInfo.UPDATE + entity + LogInfo.FAILED, e.getCause());
            return false;
        }
        logger.info(LogInfo.UPDATE + entity + LogInfo.SUCCESS);
        return true;
    }
    static  List<Order> initOrderList(ResultSet rs) throws SQLException {
        List<Order> orders = new ArrayList<>();
        while (rs.next()) {
            Order order = new Order.OrderBuilderImpl()
                    .setId(rs.getLong(1))
                    .setUserId(rs.getLong(2))
                    .setProductId(rs.getLong(3))
                    .build();
            orders.add(order);
        }
        return orders;
    }

    @Override
    public Order getOrderByUserId(Long userId) throws NamingException, SQLException {
        logger.info(LogInfo.GET_ORDER_BY_USERID + userId + LogInfo.STARTED);
        Order order;
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQLConstants.SELECT_ORDER_BY_USERID.getConstant())) {

            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();

            List<Order> orders = initOrderList(resultSet);
            if (!orders.isEmpty()) {
                order = orders.get(0);
            } else {
                logger.warn("Order by user id wasn't found. Returning null");
                return null;
            }

        }
        logger.info(LogInfo.GET_ORDER_BY_USERID + userId + LogInfo.SUCCESS);
        return order;
    }
    @Override
    public Order getOrderByProductId(Long productId) throws NamingException, SQLException{
        logger.info(LogInfo.GET_ORDER_BY_PRODUCTID + productId + LogInfo.STARTED);
        Order order;
        try (Connection connection = Connector.getInstance().getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQLConstants.SELECT_ORDER_BY_USERID.getConstant())) {

            statement.setLong(1, productId);
            ResultSet resultSet = statement.executeQuery();

            List<Order> orders = initOrderList(resultSet);
            if (!orders.isEmpty()) {
                order = orders.get(0);
            } else {
                logger.warn("Order by product id wasn't found. Returning null");
                return null;
            }

        }
        logger.info(LogInfo.GET_ORDER_BY_USERID + productId + LogInfo.SUCCESS);
        return order;
    }
}
