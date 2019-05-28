package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import java.util.List;

public class AbstractBaseDAO {

    @Autowired
    protected SessionFactory sessionFactory;

    protected void save(Object obj) {
        Transaction tx =this.sessionFactory.getCurrentSession().getTransaction();
        tx.begin();
        sessionFactory.getCurrentSession().save(obj);
        tx.commit();
    }

    protected List<Object> getAll(String queryString){
        Transaction tx =this.sessionFactory.getCurrentSession().getTransaction();
        tx.begin();
        List<Object> objects = this.sessionFactory.getCurrentSession().createQuery(queryString).list();
        tx.commit();
        return objects;
    }

    protected void update(Object object){
        Transaction tx =this.sessionFactory.getCurrentSession().getTransaction();
        tx.begin();
        this.sessionFactory.getCurrentSession().saveOrUpdate(object);
        tx.commit();
    }

    protected void delete(Object object){
        Transaction tx =this.sessionFactory.getCurrentSession().getTransaction();
        tx.begin();
        this.sessionFactory.getCurrentSession().delete(object);
        tx.commit();
    }

    protected Object findById(long id,Class<?> type) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        Object object = (Object) session.get(type, id);
        tx.commit();
        return object;
    }

    public void setSessionFactory(org.hibernate.SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        sessionFactory.openSession();
    }
}
