package by.yurusova.entranceExam.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Abstract DAO class.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Transactional
public abstract class AbstractBaseDAO<T> {

    protected SessionFactory sessionFactory;

    /**
     * Method saves object to database.
     *
     * @param obj the object.
     */
    protected void save(final T obj) {
        sessionFactory.getCurrentSession().save(obj);
    }

    /**
     * Returns list of objects from db.
     *
     * @param queryString the query string.
     * @return list of object.
     */
    protected List<T> getAll(final String queryString) {
        return sessionFactory.getCurrentSession().createQuery(queryString).list();
    }

    /**
     * Update object in db.
     *
     * @param object the updated object.
     */
    protected void update(final T object) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(object);
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
    protected Object findById(final long id, final Class<?> type) {
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
