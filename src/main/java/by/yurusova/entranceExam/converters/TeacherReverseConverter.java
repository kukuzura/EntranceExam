package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.TeacherDTO;
import by.yurusova.entranceExam.entities.Teacher;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter from TeacherDTO to Teacher.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class TeacherReverseConverter implements Converter<TeacherDTO, Teacher> {

    @Override
    public Teacher convert(final TeacherDTO source) {
        return new Teacher(source.getFirstName(), source.getLastName(), source.getPatronymic());
    }
}
