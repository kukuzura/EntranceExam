package by.yurusova.entranceExam.validator;


import by.yurusova.entranceExam.entity.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Student.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Student student = (Student) o;
        String onlyLetters = "^[\\\\p{L}\\\\p{M}' \\\\.\\\\-]+$\"";
        String onlyNumbers = "[0-9]{7}";
        if (!student.getFirstName().matches(onlyLetters)) {
            errors.rejectValue("firstName", "studentRegistration.error.firstName");
        }
        if (!student.getLastName().matches(onlyLetters)) {
            errors.rejectValue("lastName", "studentRegistration.error.lastName");
        }
        if (!student.getPatronymic().matches(onlyLetters)) {
            errors.rejectValue("patronymic", "studentRegistration.error.patronymic");
        }
        if (!student.getPassportID().matches(onlyNumbers)) {
            errors.rejectValue("passportID", "studentRegistration.error.passportID");
        }
    }
}
