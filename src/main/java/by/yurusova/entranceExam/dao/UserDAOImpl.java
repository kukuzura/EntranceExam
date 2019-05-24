package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        sessionFactory.openSession();
    }

    @Override
    public User findById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        return user;
    }

    @Override
    public void saveUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            Transaction tx =session.getTransaction();
            tx.begin();
            session.persist(user);
            if(!tx.wasCommitted()) {
                tx.commit();
            }
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
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
}
