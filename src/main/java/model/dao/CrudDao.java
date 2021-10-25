package model.dao;

import model.exception.DataBaseException;
import model.entity.Model;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface CrudDao<K, T extends Model> {

    boolean add(T entity) throws DataBaseException, SQLException, NamingException;

    T getById(K id) throws DataBaseException;

    boolean deleteEntity(K id) throws NamingException, SQLException;

    T updateEntity(T entity);


}

