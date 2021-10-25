package model.dao.factory;

import model.dao.OrderDao;
import model.dao.ProductDao;
import model.dao.UserDao;

public abstract class DaoFactory  {

    private static DaoFactory instance;

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DatabaseDaoFactory();
        }
        return instance;
    }

    public abstract UserDao getUserDAO();
    public abstract OrderDao getOrderDAO();
    public abstract ProductDao getProductDao();

}
