package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.RoleDAO;
import by.yurusova.entranceExam.dao.RoleDAOImpl;
import by.yurusova.entranceExam.entity.Role;
import org.springframework.beans.factory.annotation.Required;

/**
 * Class that performe base role services.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 *  @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class RoleServiceImpl implements RoleService {

    private RoleDAO roleDAO;

    @Override
    public Role findByName(final String roleName) {
        return roleDAO.findByName(roleName);
    }

    /**
     * Set role dao.
     *
     * @param roleDAO roleDAO to be set.
     */
    public void setRoleDAO(final RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
}

