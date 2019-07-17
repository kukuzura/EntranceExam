package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.UserDTO;
import by.yurusova.entranceExam.entities.User;

/**
 * Two way converter from User to UserDTO and back.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class UserConverter implements TwoWayConverter<User, UserDTO> {

    @Override
    public UserDTO convert(final User source) {
        return new UserDTO(source.getId(), source.getLogin(), source.getPassword());
    }

    @Override
    public User convertBack(final UserDTO target) {
        User user = new User(target.getLogin(), target.getPassword());
        user.setId(target.getId());
        return user;
    }
}
