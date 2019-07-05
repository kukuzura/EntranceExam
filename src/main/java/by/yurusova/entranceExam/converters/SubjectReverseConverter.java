package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.SubjectDTO;
import by.yurusova.entranceExam.entities.Subject;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter from SubjectDTO to Subject.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SubjectReverseConverter implements Converter<SubjectDTO, Subject> {

    @Override
    public Subject convert(final SubjectDTO source) {
        return new Subject(source.getId(), source.getName());
    }
}
