package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.TeacherDTO;
import by.yurusova.entranceExam.entities.Teacher;

/**
 * Two way converter from Teacher to TeacherDTO and back.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solutions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class TeacherConverter implements TwoWayConverter<Teacher, TeacherDTO> {

    @Override
    public TeacherDTO convert(final Teacher source) {
        return new TeacherDTO(source.getId(), source.getFirstName(), source.getLastName(), source.getPatronymic());
    }

    @Override
    public Teacher convertBack(final TeacherDTO target) {
        Teacher teacher = new Teacher(target.getFirstName(), target.getLastName(), target.getPatronymic());
        teacher.setId(target.getId());
        return teacher;
    }
}
