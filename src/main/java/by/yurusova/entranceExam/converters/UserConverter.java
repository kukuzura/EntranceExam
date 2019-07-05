package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.UserDTO;
import by.yurusova.entranceExam.entities.User;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter from User to UserDTO.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class UserConverter implements Converter<User, UserDTO> {

    @Override
    public UserDTO convert(final User source) {
        return new UserDTO(source.getId(), source.getLogin(), source.getPassword());
    }
}
