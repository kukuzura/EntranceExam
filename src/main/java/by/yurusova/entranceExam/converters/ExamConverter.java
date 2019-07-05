package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.ExamDTO;
import by.yurusova.entranceExam.dto.SpecialityDTO;
import by.yurusova.entranceExam.dto.SubjectDTO;
import by.yurusova.entranceExam.dto.TeacherDTO;
import by.yurusova.entranceExam.entities.Exam;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter from Exam to ExamDTO.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class ExamConverter implements Converter<Exam, ExamDTO> {

    private TeacherConverter teacherConverter;

    private SubjectConverter subjectConverter;

    private SpecialityConverter specialityConverter;

    @Override
    public ExamDTO convert(final Exam source) {
        TeacherDTO teacherDTO = teacherConverter.convert(source.getTeacher());
        SubjectDTO subjectDTO = subjectConverter.convert(source.getSubject());
        SpecialityDTO specialityDTO = specialityConverter.convert(source.getSpeciality());
        return new ExamDTO(source.getId(), teacherDTO, subjectDTO, specialityDTO);
    }

    /**
     * Sets teacher converter.
     *
     * @param teacherConverter converter to be set.
     */
    public void setTeacherConverter(final TeacherConverter teacherConverter) {
        this.teacherConverter = teacherConverter;
    }

    /**
     * Sets subjects converter.
     *
     * @param subjectConverter converter to be set.
     */
    public void setSubjectConverter(final SubjectConverter subjectConverter) {
        this.subjectConverter = subjectConverter;
    }

    /**
     * Sets speciality converter.
     *
     * @param specialityConverter converter to be set.
     */
    public void setSpecialityConverter(final SpecialityConverter specialityConverter) {
        this.specialityConverter = specialityConverter;
    }
}
