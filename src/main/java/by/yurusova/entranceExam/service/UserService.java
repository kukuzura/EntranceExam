package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void deleteUser(long id);
    User editUser(User user);
    List<User> getAll();
}
