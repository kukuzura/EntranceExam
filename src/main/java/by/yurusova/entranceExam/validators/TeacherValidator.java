package by.yurusova.entranceExam.validators;

import by.yurusova.entranceExam.dto.TeacherDTO;
import by.yurusova.entranceExam.properties.ApplicationProperties;
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

    private ApplicationProperties applicationProperties;

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
        if (teacher.getFirstName().length() > Integer.valueOf(applicationProperties.getMaxLength())) {
            errors.rejectValue("firstName", "teacherRegistration.error.firstName.length");
        }
        if (teacher.getLastName().length() > Integer.valueOf(applicationProperties.getMaxLength())) {
            errors.rejectValue("lastName", "teacherRegistration.error.lastName.length");
        }
        if (teacher.getPatronymic().length() > Integer.valueOf(applicationProperties.getMaxLength())) {
            errors.rejectValue("patronymic", "teacherRegistration.error.patronymic.length");
        }
        if (!teacher.getFirstName().matches(applicationProperties.getOnlyLettersRegEx())) {
            errors.rejectValue("firstName", "teacherRegistration.error.firstName");
        }
        if (!teacher.getLastName().matches(applicationProperties.getOnlyLettersRegEx())) {
            errors.rejectValue("lastName", "teacherRegistration.error.lastName");
        }
        if (!teacher.getPatronymic().matches(applicationProperties.getOnlyLettersRegEx())) {
            errors.rejectValue("patronymic", "teacherRegistration.error.patronymic");
        }
    }
    /**
     * Sets object that contains project constants.
     * @param applicationProperties the object.
     */
    public void setApplicationProperties(final ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }
}
