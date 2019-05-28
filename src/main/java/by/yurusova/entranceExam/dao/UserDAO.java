package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.User;


import java.util.List;

public interface UserDAO {
    User findById(long id);

    void saveUser(User user);

    void delete(User user);

    void update (User user);

    List<User> getAll();
}
