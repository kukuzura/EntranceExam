package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.User;


import java.util.List;

public interface UserDAO {
    /**
     * Get user by id.
     *
     * @param id the user id
     * @return the user
     */
    User findById(long id);

    /**
     * Save user to database
     *
     * @param user the user
     */
    void saveUser(User user);

    /**
     * Delete user from database
     *
     * @param user the user
     */
    void delete(User user);

    /**
     * Update user in database
     *
     * @param user the user
     */
    void update(User user);

    /**
     * Get users list from database
     * @return the list of users
     */
    List<User> getAll();
}
