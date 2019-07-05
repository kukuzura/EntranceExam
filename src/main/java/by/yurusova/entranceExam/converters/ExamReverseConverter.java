package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.ExamDTO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.entities.Subject;
import by.yurusova.entranceExam.entities.Teacher;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter from ExamDTO to Exam.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class ExamReverseConverter implements Converter<ExamDTO, Exam> {

    private TeacherReverseConverter teacherReverseConverter;

    private SubjectReverseConverter subjectReverseConverter;

    private SpecialityReverseConverter specialityReverseConverter;

    @Override
    public Exam convert(final ExamDTO source) {
        Teacher teacher = teacherReverseConverter.convert(source.getTeacherDTO());
        Subject subject = subjectReverseConverter.convert(source.getSubjectDTO());
        Speciality speciality = specialityReverseConverter.convert(source.getSpecialityDTO());
        return new Exam(source.getId(), teacher, subject, speciality);
    }
}
