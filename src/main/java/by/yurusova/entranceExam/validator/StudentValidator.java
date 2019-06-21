package by.yurusova.entranceExam.validator;

import by.yurusova.entranceExam.entity.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Class for validation of student information.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class StudentValidator implements Validator {
    private static final String ONLY_LETTERS = "^\\D+$";
    private static final String ONLY_NUMBERS = "[0-9]{7}";

    @Override
    public boolean supports(final Class<?> aClass) {
        return Student.class.equals(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors) {
        Student student = (Student) o;
        if (!student.getFirstName().matches(ONLY_LETTERS)) {
            errors.rejectValue("firstName", "studentRegistration.error.firstName");
        }
        if (!student.getLastName().matches(ONLY_LETTERS)) {
            errors.rejectValue("lastName", "studentRegistration.error.lastName");
        }
        if (!student.getPatronymic().matches(ONLY_LETTERS)) {
            errors.rejectValue("patronymic", "studentRegistration.error.patronymic");
        }
        if (!student.getPassportID().matches(ONLY_NUMBERS)) {
            errors.rejectValue("passportID", "studentRegistration.error.passportID");
        }
    }
}

