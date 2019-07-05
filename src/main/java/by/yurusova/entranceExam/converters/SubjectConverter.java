package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.SubjectDTO;
import by.yurusova.entranceExam.entities.Subject;
import org.springframework.core.convert.converter.Converter;

/**
 * Converter from Subject to SubjectDTO.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SubjectConverter implements Converter<Subject, SubjectDTO> {

    @Override
    public SubjectDTO convert(final Subject source) {
        return new SubjectDTO(source.getId(), source.getName());
    }
}
