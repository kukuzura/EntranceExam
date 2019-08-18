package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.UserDAO;
import by.yurusova.entranceExam.entities.User;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class that responsible for operations with user table.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class UserDAOImpl extends AbstractBaseDAO<User> implements UserDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);

    @Override
    public User findById(final long id) {
        return super.findById(id, User.class);
    }

    @Override
    public void saveUser(final User user) {
        super.save(user);
    }

    @Override
    public void delete(final User user) {
        super.delete(user);
    }

    @Override
    public void update(final User user) {
        super.update(user);
    }


    @Override
    public List<User> getAll() {
        return super.getAll("from User", User.class);
    }

    @Transactional
    @Override
    public User findByLogin(final String login) {
        User user = null;
        try {
            user = sessionFactory.getCurrentSession().createQuery(
                    "SELECT user FROM User user WHERE user.login LIKE: login", User.class)
                    .setParameter("login", login)
                    .getSingleResult();
        }
        catch (NoResultException ex) {
            LOGGER.error("No user found");
        }
        return user;
    }

    @Override
    public List<User> getAllForPagination(final int currentPage, final int numberOfRecordsPerPage) {
        List<User> users = new ArrayList<>();
        try {
            users = sessionFactory.getCurrentSession().createQuery(
                    "FROM User", User.class)
                    .setFirstResult(currentPage)
                    .setMaxResults(numberOfRecordsPerPage)
                    .list();
        }
        catch (NoResultException ex) {
            LOGGER.error("No users found fpr pagination");
        }
        return users;
    }

    /**
     * Gets sessionFactory.
     *
     * @return sessionFactory.
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
