package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.UserDAO;
import by.yurusova.entranceExam.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * Class that perform base user services.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

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
    public User findByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    @Override
    public void deleteUser(final long id) {
        User user = userDAO.findById(id);
        userDAO.delete(user);
    }

    @Override
    public void editUser(final User user) {
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
