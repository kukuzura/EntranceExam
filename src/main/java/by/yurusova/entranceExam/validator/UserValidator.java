package by.yurusova.entranceExam.validator;

import by.yurusova.entranceExam.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Class for validation of user information.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class UserValidator implements Validator {
    private static final String VALID_PASSWORD =
            "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";

    @Override
    public boolean supports(final Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors) {
        User user = (User) o;
        if (isEmpty(user.getLogin())) {
            errors.rejectValue("login", "registration.error.login.required");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "registration.error.login.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "registration.error.password.required");
        if (!Pattern.matches(VALID_PASSWORD, user.getPassword())) {
            errors.rejectValue("password", "registration.error.password.weakPassword");
        }
    }
}
