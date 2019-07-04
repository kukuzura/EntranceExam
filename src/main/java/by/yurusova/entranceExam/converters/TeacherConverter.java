package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.TeacherDTO;
import by.yurusova.entranceExam.entities.Teacher;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter from Teacher to TeacherDTO.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class TeacherConverter implements Converter<Teacher, TeacherDTO> {

    @Override
    public TeacherDTO convert(final Teacher source) {
        return new TeacherDTO(source.getFirstName(), source.getLastName(), source.getPatronymic());
    }
}
