package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class UserDAOImpl extends AbstractBaseDAO implements UserDAO {


    @Override
    public User findById(long id) {
        return (User) super.findById(id, User.class);
    }

    @Override
    public void saveUser(User user) {
        super.save(user);
    }

    @Override
    public void delete(User user) {
        super.delete(user);
    }

    @Override
    public void update(User user) {
        super.update(user);
    }


    @Override
    public List<User> getAll() {
        List users = super.getAll("from User");
        return (List<User>) users;
    }

    @Transactional
    @Override
    public User findByLogin(String login) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        Object user = criteria.add(Restrictions.eq("login", login))
                .uniqueResult();
        return (User) user;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
