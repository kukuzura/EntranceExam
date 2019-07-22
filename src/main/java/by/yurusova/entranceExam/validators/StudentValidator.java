package by.yurusova.entranceExam.validators;

import by.yurusova.entranceExam.dto.StudentDTO;
import by.yurusova.entranceExam.properties.ApplicationProperties;
import by.yurusova.entranceExam.services.interfaces.StudentService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Class for validation of student information.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.validators
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class StudentValidator implements Validator {

    private ApplicationProperties applicationProperties;

    private StudentService studentService;

    @Override
    public boolean supports(final Class<?> aClass) {
        return StudentDTO.class.equals(aClass);
    }

    @Override
    public void validate(final Object o, final Errors errors) {
        StudentDTO student = (StudentDTO) o;
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
        if (student.getFirstName().length() > Integer.valueOf(applicationProperties.getMaxLength())) {
            errors.rejectValue("firstName", "studentRegistration.error.firstName.length");
        }
        if (student.getLastName().length() > Integer.valueOf(applicationProperties.getMaxLength())) {
            errors.rejectValue("lastName", "studentRegistration.error.lastName.length");
        }
        if (student.getPatronymic().length() > Integer.valueOf(applicationProperties.getMaxLength())) {
            errors.rejectValue("patronymic", "studentRegistration.error.patronymic.length");
        }
        if (!student.getFirstName().matches(applicationProperties.getOnlyLettersRegEx())) {
            errors.rejectValue("firstName", "studentRegistration.error.firstName");
        }
        if (!student.getLastName().matches(applicationProperties.getOnlyLettersRegEx())) {
            errors.rejectValue("lastName", "studentRegistration.error.lastName");
        }
        if (!student.getPatronymic().matches(applicationProperties.getOnlyLettersRegEx())) {
            errors.rejectValue("patronymic", "studentRegistration.error.patronymic");
        }
        if (!student.getPassportID().matches(applicationProperties.getOnlyNumbersRegEx())) {
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

    /**
     * Sets object that contains project constants.
     * @param applicationProperties the object.
     */
    public void setApplicationProperties(final ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }
}

