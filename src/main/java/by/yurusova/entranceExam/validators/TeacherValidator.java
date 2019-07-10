package by.yurusova.entranceExam.validators;

import by.yurusova.entranceExam.dto.TeacherDTO;
import by.yurusova.entranceExam.entities.Teacher;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

/**
 * Class for validation of teacher information.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.validators
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class TeacherValidator implements Validator {
    private static final String ONLY_LETTERS = "^\\D+$";
    private static final int MAX_LENGTH = 30;

    @Override
    public boolean supports(final Class<?> clazz) {
        return TeacherDTO.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        TeacherDTO teacher = (TeacherDTO) target;
        if (isEmpty(teacher.getFirstName())) {
            errors.rejectValue("firstName", "teacherRegistration.error.firstName.required");
        }
        if (isEmpty(teacher.getLastName())) {
            errors.rejectValue("lastName", "teacherRegistration.error.lastName.required");
        }
        if (isEmpty(teacher.getPatronymic())) {
            errors.rejectValue("patronymic", "teacherRegistration.error.lastName.required");
        }
        if (teacher.getFirstName().length() > MAX_LENGTH) {
            errors.rejectValue("firstName", "teacherRegistration.error.firstName.length");
        }
        if (teacher.getLastName().length() > MAX_LENGTH) {
            errors.rejectValue("lastName", "teacherRegistration.error.lastName.length");
        }
        if (teacher.getPatronymic().length() > MAX_LENGTH) {
            errors.rejectValue("patronymic", "teacherRegistration.error.patronymic.length");
        }
        if (!teacher.getFirstName().matches(ONLY_LETTERS)) {
            errors.rejectValue("firstName", "teacherRegistration.error.firstName");
        }
        if (!teacher.getLastName().matches(ONLY_LETTERS)) {
            errors.rejectValue("lastName", "teacherRegistration.error.lastName");
        }
        if (!teacher.getPatronymic().matches(ONLY_LETTERS)) {
            errors.rejectValue("patronymic", "teacherRegistration.error.patronymic");
        }
    }
}
