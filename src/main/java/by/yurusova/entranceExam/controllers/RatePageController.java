package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.dto.StudentForm;
import by.yurusova.entranceExam.facades.RateFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for page of student rating.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
@RequestMapping("/account")
public class RatePageController {

    @Autowired
    private RateFacade rateFacade;

    /**
     * Method shows rate page with list of students that register for exam with given id.
     *
     * @param examId id of exam.
     * @return rate page.
     */
    @RequestMapping(value = "rate/{id}", method = RequestMethod.GET)
    public ModelAndView showRatePage(@PathVariable("id") final long examId) {
        return rateFacade.showRatePage(examId);
    }

    /**
     * Method saves students grades to db, and shows teacherPage.
     *
     * @param examId      id of exam whose register students rates are set.
     * @param studentForm container that contains list of studentDTO.
     * @return teacher page.
     */
    @RequestMapping(value = "rate/{id}", method = RequestMethod.POST)
    public String setRates(@PathVariable("id") final long examId, @ModelAttribute("studentForm") final StudentForm studentForm) {
        rateFacade.rateStudents(studentForm.getStudents(), examId);
        return "/teacherPage.jsp";
    }
}

