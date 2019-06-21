package by.yurusova.entranceExam.validator;

import by.yurusova.entranceExam.entity.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {
    private static final String ONLY_LETTERS = "^\\D+$";
    private static final String ONLY_NUMBERS = "[0-9]{7}";

    @Override
    public boolean supports(Class<?> aClass) {
        return Student.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
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

