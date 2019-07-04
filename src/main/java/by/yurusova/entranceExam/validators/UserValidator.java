package by.yurusova.entranceExam.validators;

import by.yurusova.entranceExam.dto.UserDTO;
import by.yurusova.entranceExam.services.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Class for validation of user information.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.validators
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class UserValidator implements Validator {
    private static final String VALID_PASSWORD =
            "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";
    private static final int MAX_LENGTH = 30;

    private UserService userService;

    @Override
    public boolean supports(final Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors) {
        UserDTO user = (UserDTO) o;
        if (isEmpty(user.getLogin())) {
            errors.rejectValue("login", "registration.error.login.required");
        }
        if (isEmpty(user.getPassword())) {
            errors.rejectValue("password", "registration.error.password.required");
        }
        if (user.getLogin().length() > MAX_LENGTH) {
            errors.rejectValue("password", "registration.error.password.length");
        }
        if (user.getPassword().length() > MAX_LENGTH) {
            errors.rejectValue("password", "registration.error.login.length");
        }
        if (!Pattern.matches(VALID_PASSWORD, user.getPassword())) {
            errors.rejectValue("password", "registration.error.password.weakPassword");
        }
        if (userService.findByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "registration.error.login.exists");
        }
    }

    /**
     * Method sets userService.
     *
     * @param userService userService to be set.
     */
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }
}
