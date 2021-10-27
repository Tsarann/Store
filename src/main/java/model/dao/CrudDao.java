package model.dao;


import model.entity.Model;

import javax.naming.NamingException;
import java.sql.SQLException;

public interface CrudDao<K, T extends Model> {

    boolean add(T entity) throws  SQLException, NamingException;

    T getById(K id) throws NamingException, SQLException;

    boolean deleteEntity(K id) throws NamingException;

    boolean updateEntity(T entity) throws NamingException;


}

