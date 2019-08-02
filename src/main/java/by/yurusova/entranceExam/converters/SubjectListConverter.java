package by.yurusova.entranceExam.converters;

import by.yurusova.entranceExam.dto.SubjectDTO;
import by.yurusova.entranceExam.entities.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Two way converter from list of Subject to list of SubjectDTO and back.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SubjectListConverter implements ListTwoWayConverter<Subject, SubjectDTO> {

    private SubjectConverter subjectConverter;

    @Override
    public List<SubjectDTO> convertList(final List<Subject> source) {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        for (Subject subject : source) {
            subjectDTOS.add(subjectConverter.convert(subject));
        }
        return subjectDTOS;
    }

    @Override
    public List<Subject> convertBackList(final List<SubjectDTO> target) {
        List<Subject> subjects = new ArrayList<>();
        for (SubjectDTO subjectDTO : target) {
            subjects.add(subjectConverter.convertBack(subjectDTO));
        }
        return subjects;
    }

    /**
     * Sets subject converter.
     *
     * @param subjectConverter converter to be set.
     */
    public void setSubjectConverter(final SubjectConverter subjectConverter) {
        this.subjectConverter = subjectConverter;
    }
}
