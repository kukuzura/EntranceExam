package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.RoleDAO;
import by.yurusova.entranceExam.dao.UserDAO;
import by.yurusova.entranceExam.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    private RoleDAO roleDAO;

    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleDAO.getAll()));
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

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }
}
