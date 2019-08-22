package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.StudentDTO;
import by.yurusova.entranceExam.entities.Student;

/**
 * Two way converter from Student to StudentDTO, and back, for student grading.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class StudentConverterForRate implements TwoWayConverter<Student, StudentDTO> {

    @Override
    public StudentDTO convert(final Student source) {
        return new StudentDTO(
                source.getId(), source.getPassportID(), source.getLastName(), source.getFirstName(), source.getPatronymic());
    }

    @Override
    public Student convertBack(final StudentDTO target) {
        Student student = new Student(
                target.getPassportID(), target.getFirstName(), target.getLastName(), target.getPatronymic());
        student.setId(target.getId());
        return student;
    }
}
