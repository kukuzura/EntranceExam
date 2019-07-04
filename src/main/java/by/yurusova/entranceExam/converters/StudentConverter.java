package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.StudentDTO;
import by.yurusova.entranceExam.entities.Student;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter from Student to StudentDTO .
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class StudentConverter implements Converter<Student, StudentDTO> {

    @Override
    public StudentDTO convert(final Student source) {
        return new StudentDTO(source.getPassportID(), source.getFirstName(), source.getLastName(), source.getPatronymic());
    }
}
