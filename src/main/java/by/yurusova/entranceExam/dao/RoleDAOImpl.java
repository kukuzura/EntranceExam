package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DAO class that responsible for operations with roles table.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class RoleDAOImpl extends AbstractBaseDAO implements RoleDAO {

    @Override
    public Role findById(final long id) {
        return (Role) super.findById(id, Role.class);
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
        List roles = super.getAll("from Role");
        return (List<Role>) roles;
    }

    @Override
    @Transactional
    public Role findByName(final String name) {
        Object role = sessionFactory.getCurrentSession().createQuery(
                "SELECT role FROM Role role WHERE role.name LIKE: name")
                .setParameter("name", name)
                .getSingleResult();
        return (Role) role;
    }

}
