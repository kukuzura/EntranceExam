package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.UserDTO;
import by.yurusova.entranceExam.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Two way converter from list of User to list of UserDTO and back.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class UserListConverter implements ListTwoWayConverter<User, UserDTO> {

    private UserConverter userConverter;

    @Override
    public List<UserDTO> convertList(final List<User> source) {
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : source) {
            userDTOS.add(userConverter.convert(user));
        }
        return userDTOS;
    }

    @Override
    public List<User> convertBackList(final List<UserDTO> target) {
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : target) {
            users.add(userConverter.convertBack(userDTO));
        }
        return users;
    }

    /**
     * Sets user converter.
     *
     * @param userConverter converter to be set.
     */
    public void setUserConverter(final UserConverter userConverter) {
        this.userConverter = userConverter;
    }
}
