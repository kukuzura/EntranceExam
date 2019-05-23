package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Override
    public User findById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        return user;
    }

    @Override
    public void saveUser(User user) {
        //Session session = sessionFactory.openSession();
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteUserById(long id) {

    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User findEmployeeById(long id) {
        return null;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
