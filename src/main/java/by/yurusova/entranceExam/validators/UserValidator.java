package by.yurusova.entranceExam.validators;

import by.yurusova.entranceExam.dto.UserDTO;
import by.yurusova.entranceExam.properties.ApplicationProperties;
import by.yurusova.entranceExam.services.interfaces.UserService;
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

    private ApplicationProperties applicationProperties;

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
        if (user.getLogin().length() > Integer.valueOf(applicationProperties.getMaxLength())) {
            errors.rejectValue("password", "registration.error.password.length");
        }
        if (user.getPassword().length() > Integer.valueOf(applicationProperties.getMaxLength())) {
            errors.rejectValue("password", "registration.error.login.length");
        }
        if (!Pattern.matches(applicationProperties.getValidPassRegEx(), user.getPassword())) {
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
    /**
     * Sets object that contains project constants.
     * @param applicationProperties the object.
     */
    public void setApplicationProperties(final ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }
}
