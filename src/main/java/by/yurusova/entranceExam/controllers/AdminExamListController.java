package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * List of exam page(for admin) controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
@RequestMapping("/admin")
public class AdminExamListController {

    @Autowired
    private ExamService examService;

    /**
     * Method shows the lit of exams.
     *
     * @return page with list of exams.
     */
    @RequestMapping(value = "examList", method = RequestMethod.GET)
    ModelAndView showExamList() {
        ModelAndView mav = new ModelAndView("/examListPage.jsp");
        List<Exam> exams = examService.getAll();
        mav.addObject("examList", exams);
        return mav;
    }

    /**
     * Method delete exam with given id.
     *
     * @param id the id.
     * @return page with list of exams.
     */
    @RequestMapping(value = "/examDelete/{id}", method = RequestMethod.GET)
    public ModelAndView showDelete(@PathVariable("id") final long id) {
        examService.deleteExam(id);
        ModelAndView mav = new ModelAndView("/examListPage.jsp");
        List<Exam> exams = examService.getAll();
        mav.addObject("examList", exams);
        return mav;
    }
}
