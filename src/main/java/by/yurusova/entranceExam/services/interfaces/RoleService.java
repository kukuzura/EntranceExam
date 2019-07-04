package by.yurusova.entranceExam.services.interfaces;

import by.yurusova.entranceExam.entities.Role;

/**
 * Interface defines base role services operations.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface RoleService {

    /**
     * Finds role by name.
     *
     * @param roleName name of role.
     * @return role with given name.
     */
    Role findByName(String roleName);
}

