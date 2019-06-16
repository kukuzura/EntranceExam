package by.yurusova.entranceExam.validator;

import by.yurusova.entranceExam.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "registration.error.login.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "registration.error.password.required");
        if (!Pattern.matches("^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$", user.getPassword())){
            errors.rejectValue("password","registration.error.password.weakPassword");
        }
    }
}
