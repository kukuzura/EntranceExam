package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.UserConverter;
import by.yurusova.entranceExam.converters.UserReverseConverter;
import by.yurusova.entranceExam.dto.UserDTO;
import by.yurusova.entranceExam.entities.User;
import by.yurusova.entranceExam.services.interfaces.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade for operations with users.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.facades
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class UserOperationsFacade {

    private UserService userService;

    private UserReverseConverter userReverseConverter;

    private UserConverter userConverter;

    /**
     * Method convert userDTO to user
     * and updates user in db.
     *
     * @param userDTO users dto.
     */
    public void update(final UserDTO userDTO) {
        User user = userReverseConverter.convert(userDTO);
        userService.editUser(user);
    }

    /**
     * Method delete user by id.
     *
     * @param userID the id.
     */
    public void delete(final long userID) {
        userService.deleteUser(userID);
    }

    /**
     * Method gets all users from db and converts then to UserDTO.
     *
     * @return list of userDTO.
     */
    public List<UserDTO> getAll() {
        List<User> users = userService.getAll();
        List<UserDTO> dtoList = new ArrayList<UserDTO>();
        for (User user : users) {
            dtoList.add(userConverter.convert(user));
        }
        return dtoList;
    }

    /**
     * Method gets user by id and convert it to userDTO.
     *
     * @param id the id.
     * @return the userDTO.
     */
    public UserDTO findById(final long id) {
        User user = userService.findById(id);
        return userConverter.convert(user);
    }

    /**
     * Sets user service.
     *
     * @param userService service to be set.
     */
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    /**
     * Sets user converter.
     *
     * @param userConverter converter to be set.
     */
    public void setUserConverter(final UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    /**
     * Sets user reverse converter.
     *
     * @param userReverseConverter converter to be set.
     */
    public void setUserReverseConverter(final UserReverseConverter userReverseConverter) {
        this.userReverseConverter = userReverseConverter;
    }
}
