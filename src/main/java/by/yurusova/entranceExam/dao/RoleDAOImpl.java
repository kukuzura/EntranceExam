package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.dao.interfaces.RoleDAO;
import by.yurusova.entranceExam.entities.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * DAO class that responsible for operations with roles table.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class RoleDAOImpl extends AbstractBaseDAO<Role> implements RoleDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(RoleDAOImpl.class);

    @Override
    public Role findById(final long id) {
        return super.findById(id, Role.class);
    }

    @Override
    public void saveRole(final Role role) {
        super.save(role);
    }

    @Override
    public void delete(final Role role) {
        super.delete(role);
    }

    @Override
    public void update(final Role role) {
        super.update(role);
    }

    @Override
    public List<Role> getAll() {
        return super.getAll("from Role", Role.class);
    }

    @Override
    @Transactional
    public Role findByName(final String name) {
        Role role = null;
        try {
            role = sessionFactory.getCurrentSession().createQuery(
                    "SELECT role FROM Role role WHERE role.name LIKE: name", Role.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }
        catch (NoResultException e) {
            LOGGER.error("No role found");
        }
        return role;
    }

}
