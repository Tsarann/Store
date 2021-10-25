package model.dao.factory;

import model.dao.OrderDao;
import model.dao.ProductDao;
import model.dao.UserDao;

import model.dao.impl.OrderDaoImpl;
import model.dao.impl.ProductDaoImpl;
import model.dao.impl.UserDaoImpl;
import org.apache.log4j.Logger;

public class DatabaseDaoFactory extends DaoFactory {

    private static Logger logger = Logger.getLogger(DatabaseDaoFactory.class);

    private UserDao userDao = new UserDaoImpl();
    private ProductDao productDao = new ProductDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();


    @Override
    public OrderDao getOrderDAO() {
        logger.info("Get OrderDatabaseDao");
        return orderDao;
    }

    @Override
    public ProductDao getProductDao() {
        logger.info("Get ProductDatabaseDao");
        return productDao;
    }


    @Override
    public UserDao getUserDAO() {
        logger.info("Get UserDatabaseDao");
        return userDao;
    }
}
