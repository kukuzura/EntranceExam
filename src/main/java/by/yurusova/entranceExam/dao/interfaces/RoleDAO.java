package by.yurusova.entranceExam.dao.interfaces;

import by.yurusova.entranceExam.entities.Role;

import java.util.List;

/**
 * Interface defines base operations that can be performed with role objects.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface RoleDAO {
    /**
     * Get role object by id.
     *
     * @param id the role id.
     * @return the role object.
     */
    Role findById(long id);

    /**
     * Saves role in db.
     *
     * @param role the role object.
     */
    void saveRole(Role role);

    /**
     * Delete role from db.
     *
     * @param role the role object.
     */
    void delete(Role role);

    /**
     * Update role.
     *
     * @param role the role object.
     */
    void update(Role role);

    /**
     * Get all roles from db.
     *
     * @return list of roles.
     */
    List<Role> getAll();

    /**
     * Get role object with given name.
     *
     * @param name role name.
     * @return the role object.
     */
    Role findByName(String name);
}
