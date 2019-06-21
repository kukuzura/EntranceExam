package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.dao.RoleDAOImpl;
import by.yurusova.entranceExam.entity.Role;

/**
 * Class that performe base role services.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 *  @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class RoleServiceImpl implements RoleService {

    private RoleDAOImpl roleDAO;

    @Override
    public Role findByName(final String roleName) {
        return roleDAO.findByName(roleName);
    }

    /**
     * Set role dao.
     *
     * @param roleDAO roledao to be set.
     */
    public void setRoleDAO(final RoleDAOImpl roleDAO) {
        this.roleDAO = roleDAO;
    }
}

