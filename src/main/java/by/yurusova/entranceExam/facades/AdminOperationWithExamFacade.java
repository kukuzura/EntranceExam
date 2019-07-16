package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.ExamConverter;
import by.yurusova.entranceExam.dto.ExamDTO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.services.interfaces.ExamService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade for admin operations with exams(except adding).
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.facades
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class AdminOperationWithExamFacade {

    private ExamService examService;

    private ExamConverter examConverter;

    /**
     * Method creates ModelAndView for ExamListPage,
     * converts list of exams from db to list of userDTO and
     * sets in into page as examList attribute.
     *
     * @return page with list of exams.
     */
    public ModelAndView createExamListPage() {
        ModelAndView mav = new ModelAndView("/examListPage.jsp");
        List<Exam> exams = examService.getAll();
        List<ExamDTO> examDTOS = new ArrayList<>();
        for (Exam exam : exams) {
            examDTOS.add(examConverter.convert(exam));
        }
        mav.addObject("examList", examDTOS);
        return mav;
    }

    /**
     * Method delete exam from db by id.
     *
     * @param id id of exam to be delete.
     */
    public void deleteExam(final long id) {
        examService.deleteExam(id);
    }

    /**
     * Sets exam service.
     *
     * @param examService service to be set.
     */
    public void setExamService(final ExamService examService) {
        this.examService = examService;
    }

    /**
     * Sets exam converter.
     *
     * @param examConverter converter to be set.
     */
    public void setExamConverter(final ExamConverter examConverter) {
        this.examConverter = examConverter;
    }

}
