package by.yurusova.entranceExam.dao.interfaces;

import java.util.List;

import by.yurusova.entranceExam.entities.User;

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
    Long saveUser(User user);

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

    /**
     * Gets all users for page with given number.
     *
     * @param currentPage           page number.
     * @param amountOfRecordsOnPage amount of records per page.
     * @return list of users for page.
     */
    List<User> getAllForPagination(int currentPage, int amountOfRecordsOnPage);
}
