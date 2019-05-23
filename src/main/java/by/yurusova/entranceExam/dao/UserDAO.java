package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.User;


import java.util.List;

public interface UserDAO {
    User findById(long id);

    void saveUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    User findEmployeeById(long id);
}
