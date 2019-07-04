package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.StudentDTO;
import by.yurusova.entranceExam.entities.Student;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter from StudentDTO to Student.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class StudentReverseConverter implements Converter<StudentDTO, Student> {

    @Override
    public Student convert(final StudentDTO source) {
        return new Student(source.getPassportID(), source.getFirstName(), source.getLastName(), source.getPatronymic());
    }
}
