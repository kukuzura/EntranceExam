package by.yurusova.entranceExam.services.interfaces;

import by.yurusova.entranceExam.entities.User;

import java.util.List;

/**
 * Interface defines base role services operations.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services
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

    /**
     * Finds user by login.
     *
     * @param login the login.
     * @return user with given login.
     */
    User findByLogin(String login);

    /**
     * Gest all users for current page.
     *
     * @param currentPage   the page number.
     * @param recordsAmount amounts of records per page.
     * @return list of users.
     */
    List<User> getAllForPagination(int currentPage, int recordsAmount);
}
