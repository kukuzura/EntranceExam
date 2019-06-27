package by.yurusova.entranceExam.validator;

import by.yurusova.entranceExam.entity.User;
import by.yurusova.entranceExam.service.UserService;
import by.yurusova.entranceExam.service.UserServiceImpl;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Class for validation of user information.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.validator
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
        return User.class.equals(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors) {
        User user = (User) o;
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
        if(userService.findByLogin(user.getLogin())!=null){
            errors.rejectValue("login", "registration.error.login.exists");
        }
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
