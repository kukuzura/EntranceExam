package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.entity.Role;

/**
 * Interface defines base role service operations.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.service
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

