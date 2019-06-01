package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.UserDAO;
import by.yurusova.entranceExam.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Override
    public void addUser(User user) {
        userDAO.saveUser(user);
    }

    public User findById(long id){
        return userDAO.findById(id);
    }

    @Override
    public void deleteUser(long id) {
        User user = userDAO.findById(id);
        userDAO.delete(user);
    }

    @Override
    public void editUser(User user) {
        userDAO.update(user);
    }

    @Override
    public List<User> getAll() {
       return userDAO.getAll();
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
