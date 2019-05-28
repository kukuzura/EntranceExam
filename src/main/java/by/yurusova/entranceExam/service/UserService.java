package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUser(long id);

    void editUser(User user);

    List<User> getAll();

    public User findById(long id);
}
