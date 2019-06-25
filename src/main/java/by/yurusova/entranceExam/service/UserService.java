package by.yurusova.entranceExam.service;

import by.yurusova.entranceExam.entity.User;

import java.util.List;

/**
 * Interface defines base role service operations.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface UserService {

    /**
     * Save user to database.
     *
     * @param user the user.
     */
    void addUser(User user);

    /**
     * Delete user.
     *
     * @param id the user.
     */
    void deleteUser(long id);

    /**
     * Update user.
     *
     * @param user the user.
     */
    void editUser(User user);

    /**
     * Get list of users.
     *
     * @return list of users.
     */
    List<User> getAll();

    /**
     * Get user by id.
     *
     * @param id the id.
     * @return the user with given id.
     */
    User findById(long id);
}
