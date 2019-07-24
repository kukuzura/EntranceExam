package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.SubjectConverter;
import by.yurusova.entranceExam.converters.SubjectReverseConverter;
import by.yurusova.entranceExam.dto.SubjectDTO;
import by.yurusova.entranceExam.entities.Subject;
import by.yurusova.entranceExam.services.interfaces.SubjectService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade for operations with subjects.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.facades
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class SubjectOperationsFacade {

    private SubjectService subjectService;

    private SubjectReverseConverter subjectReverseConverter;

    private SubjectConverter subjectConverter;

    /**
     * Sets subject converter.
     *
     * @param subjectConverter converter to be set.
     */
    public void setSubjectConverter(final SubjectConverter subjectConverter) {
        this.subjectConverter = subjectConverter;
    }

    /**
     * Method creates ModelAndVies for subject list page,
     * converts it to list of subjectDTO and sets on modelAndView.
     *
     * @return subject list page.
     */
    public ModelAndView createSubjectList() {
        ModelAndView modelAndView = new ModelAndView("/adminSubjectList.jsp");
        List<Subject> subjectList = subjectService.getAll();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        for (Subject subject : subjectList) {
            subjectDTOS.add(subjectConverter.convert(subject));
        }
        modelAndView.addObject("subjectList", subjectDTOS);
        return modelAndView;
    }

    /**
     * Method converters subjectDTO to subject and saves it to database.
     *
     * @param subjectDTO dto to be convert.
     */
    public void addSubject(final SubjectDTO subjectDTO) {
        Subject subject = subjectReverseConverter.convert(subjectDTO);
        subjectService.save(subject);
    }

    /**
     * Sets subject service.
     *
     * @param subjectService service to be set.
     */
    public void setSubjectService(final SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    /**
     * Sets subject reverse converter.
     *
     * @param subjectReverseConverter converter to be set.
     */
    public void setSubjectReverseConverter(final SubjectReverseConverter subjectReverseConverter) {
        this.subjectReverseConverter = subjectReverseConverter;
    }

    /**
     * Method delete subject from database by it's id.
     *
     * @param id the id.
     */
    public void deleteSubject(final long id) {
        Subject subject = new Subject();
        subject.setId(id);
        subjectService.delete(subject);
    }
}