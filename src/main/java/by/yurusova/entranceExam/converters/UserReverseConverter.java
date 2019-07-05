package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.UserDTO;
import by.yurusova.entranceExam.entities.User;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter from UserDTO to User.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class UserReverseConverter implements Converter<UserDTO, User> {

    @Override
    public User convert(final UserDTO source) {
        User user = new User(source.getLogin(), source.getPassword());
        user.setId(source.getId());
        return user;
    }
}
