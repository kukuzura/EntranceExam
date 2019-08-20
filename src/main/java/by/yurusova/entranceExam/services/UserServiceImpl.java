package by.yurusova.entranceExam.services;

import by.yurusova.entranceExam.dao.interfaces.UserDAO;
import by.yurusova.entranceExam.entities.User;
import by.yurusova.entranceExam.services.interfaces.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * Class that perform base user services.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void addUser(final User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDAO.saveUser(user);
    }

    @Override
    public User findById(final long id) {
        return userDAO.findById(id);
    }

    @Override
    public User findByLogin(final String login) {
        return userDAO.findByLogin(login);
    }

    @Override
    public List<User> getAllForPagination(final int currentPage, final int recordsAmount) {
        return userDAO.getAllForPagination(currentPage, recordsAmount);
    }

    @Override
    public void deleteUser(final long id) {
        User user = userDAO.findById(id);
        if (user != null) {
            userDAO.delete(user);
        }
    }

    @Override
    public void editUser(final User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDAO.update(user);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    /**
     * Gets userDAO.
     *
     * @return userDAO
     */
    public UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * Set userDAO.
     *
     * @param userDAO userDAO to be set
     */
    public void setUserDAO(final UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Set encoder.
     *
     * @param bCryptPasswordEncoder encoder to be set
     */
    public void setbCryptPasswordEncoder(final BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
}
