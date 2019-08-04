package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.SubjectDTO;
import by.yurusova.entranceExam.entities.Subject;

/**
 * Two way converter from Subject to SubjectDTO and back.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SubjectConverter implements TwoWayConverter<Subject, SubjectDTO> {

    @Override
    public SubjectDTO convert(final Subject source) {
        if (source != null) {
            return new SubjectDTO(source.getId(), source.getName());
        }
        else {
            return null;
        }
    }

    @Override
    public Subject convertBack(final SubjectDTO target) {
        return new Subject(target.getId(), target.getName());
    }

}
