package by.yurusova.entranceExam.validator;

import by.yurusova.entranceExam.entity.Student;
import by.yurusova.entranceExam.service.StudentService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Class for validation of student information.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.validator
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class StudentValidator implements Validator {
    private static final String ONLY_LETTERS = "^\\D+$";
    private static final String ONLY_NUMBERS = "[0-9]{7}";
    private static final int MAX_LENGTH = 30;

    private StudentService studentService;

    @Override
    public boolean supports(final Class<?> aClass) {
        return Student.class.equals(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors) {
        Student student = (Student) o;
        if (isEmpty(student.getFirstName())) {
            errors.rejectValue("firstName", "studentRegistration.error.firstName.required");
        }
        if (isEmpty(student.getLastName())) {
            errors.rejectValue("lastName", "studentRegistration.error.lastName.required");
        }
        if (isEmpty(student.getPatronymic())) {
            errors.rejectValue("patronymic", "studentRegistration.error.lastName.required");
        }
        if (isEmpty(student.getPassportID())) {
            errors.rejectValue("passportID", "studentRegistration.error.passportID.required");
        }
        if (student.getFirstName().length() > MAX_LENGTH) {
            errors.rejectValue("firstName", "studentRegistration.error.firstName.length");
        }
        if (student.getLastName().length() > MAX_LENGTH) {
            errors.rejectValue("lastName", "studentRegistration.error.lastName.length");
        }
        if (student.getPatronymic().length() > MAX_LENGTH) {
            errors.rejectValue("patronymic", "studentRegistration.error.patronymic.length");
        }
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
        if (studentService.findByPassportID(student.getPassportID()) != null) {
            errors.rejectValue("passportID", "studentRegistration.error.passportID.exists");
        }
    }

    /**
     * Method sets studentService.
     *
     * @param studentService studentService to be set.
     */
    public void setStudentService(final StudentService studentService) {
        this.studentService = studentService;
    }
}

