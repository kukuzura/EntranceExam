package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.UserDAO;
import by.yurusova.entranceExam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userDAO.deleteUserById(id);
    }

    @Override
    public void editUser(User user) {
    }

    @Override
    public List<User> getAll() {
       return userDAO.findAllUsers();
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
