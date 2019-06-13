package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.Role;
import by.yurusova.entranceExam.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RoleDAO extends AbstractBaseDAO {

    public Role findById(long id) {
        Role role = (Role) super.findById(id, Role.class);
        return role;
    }

    public void saveRole(Role role) {
        super.save(role);
    }

    public void delete(Role role) {
        super.delete(role);
    }

    public void update(Role role) {
        super.update(role);
    }

    public List<Role> getAll() {
        List roles = super.getAll("from Role");
        return (List<Role>) roles;
    }


    @Transactional
    public Role findByName(String name) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
        Object role = criteria.add(Restrictions.eq("name", name))
                .uniqueResult();
        return (Role) role;
    }

}
