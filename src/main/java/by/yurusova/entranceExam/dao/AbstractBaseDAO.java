package by.yurusova.entranceExam.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Abstract DAO class.
 *
 * @param <T> type of object that will be used.
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public abstract class AbstractBaseDAO<T> {

    protected SessionFactory sessionFactory;

    /**
     * Method saves object to database.
     *
     * @param obj the object.
     * @return 
     */
    protected Serializable save(final T obj) {
        return sessionFactory.getCurrentSession().save(obj);
    }

    /**
     * Returns list of objects from db.
     *
     * @param type type of object that will be used.
     * @param queryString the query string.
     * @return list of object.
     */
    protected List<T> getAll(final String queryString, final Class<T> type) {
        return sessionFactory.getCurrentSession().createQuery(queryString, type).list();
    }

    /**
     * Update object in db.
     *
     * @param object the updated object.
     */
    protected void update(final T object) {
        this.sessionFactory.getCurrentSession().update(object);
    }

    /**
     * Delete object from db.
     *
     * @param object deleted object.
     */
    protected void delete(final T object) {
        this.sessionFactory.getCurrentSession().delete(object);
    }

    /**
     * Finds object by id.
     *
     * @param id   the id.
     * @param type type of object.
     * @return object of given type with given id.
     */
    protected T findById(final long id, final Class<T> type) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(type, id);
    }

    /**
     * Set sessionFactory.
     *
     * @param sessionFactory sessionFactory to set.
     */
    public void setSessionFactory(final org.hibernate.SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        sessionFactory.openSession();
    }
}
