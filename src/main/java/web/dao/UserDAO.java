package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    void add(User user);

    void remove(User user);

    void update(User user);
    User getUserById(int id);
    List<User> getUsers();

}
