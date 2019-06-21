package by.yurusova.entranceExam.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class AbstractBaseDAO {

    protected SessionFactory sessionFactory;

    protected void save(Object obj) {
        sessionFactory.getCurrentSession().save(obj);
    }

    protected List<Object> getAll(String queryString) {
        return sessionFactory.getCurrentSession().createQuery(queryString).list();
    }

    protected void update(Object object) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(object);
    }

    protected void delete(Object object) {
        this.sessionFactory.getCurrentSession().delete(object);
    }

    protected Object findById(long id, Class<?> type) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(type, id);
    }

    public void setSessionFactory(org.hibernate.SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        sessionFactory.openSession();
    }
}
