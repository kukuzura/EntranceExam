package by.yurusova.entranceExam.validator;

import by.yurusova.entranceExam.entity.Teacher;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

public class TeacherValidator implements Validator {
    private static final String ONLY_LETTERS = "^\\D+$";
    private static final int MAX_LENGTH = 30;

    @Override
    public boolean supports(Class<?> clazz) {
        return Teacher.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Teacher teacher = (Teacher) target;
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
