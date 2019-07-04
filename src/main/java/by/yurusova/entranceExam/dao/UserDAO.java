package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entities.User;


import java.util.List;

/**
 * Interface defines base operations that can be performed with user objects.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface UserDAO {
    /**
     * Get user by id.
     *
     * @param id the user id.
     * @return the user.
     */
    User findById(long id);

    /**
     * Save user to database.
     *
     * @param user the user.
     */
    void saveUser(User user);

    /**
     * Delete user from database.
     *
     * @param user the user.
     */
    void delete(User user);

    /**
     * Update user in database.
     *
     * @param user the user.
     */
    void update(User user);

    /**
     * Get users list from database.
     *
     * @return the list of users.
     */
    List<User> getAll();


    /**
     * Get user by login.
     *
     * @param login the login.
     * @return the user.
     */
    User findByLogin(String login);
}
