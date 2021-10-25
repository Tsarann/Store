package model.dao;

import model.entity.User;

import java.util.List;

public interface UserDao extends CrudDao<Integer, User> {
    List<User> getAll();

    User getByLoginAndPass(String login, String password);

    User getByLogin(String login);

    User getByEmail(String email);

    int getCountBlocked(List<User> person);
}
