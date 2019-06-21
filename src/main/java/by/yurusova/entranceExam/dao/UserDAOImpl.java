package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * DAO class that responsible for operations with user table.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class UserDAOImpl extends AbstractBaseDAO implements UserDAO {


    @Override
    public User findById(final long id) {
        return (User) super.findById(id, User.class);
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
        List users = super.getAll("from User");
        return (List<User>) users;
    }

    @Transactional
    @Override
    public User findByLogin(final String login) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        Object user = criteria.add(Restrictions.eq("login", login))
                .uniqueResult();
        return (User) user;
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
