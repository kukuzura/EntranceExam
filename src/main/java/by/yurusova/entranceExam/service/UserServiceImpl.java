package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.UserDAO;
import by.yurusova.entranceExam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{
    //@Autowired
    UserDAO userDAO;

    @Override
    public User addUser(User user){
        User savedUser = userDAO.saveAndFlush(user);
        return savedUser;
    }

    @Override
    public void deleteUser(long id) {
        userDAO.delete(id);
    }

    @Override
    public User editUser(User user) {
        return userDAO.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return userDAO.findAll();
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
