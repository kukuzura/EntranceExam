package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.facades.AdminOperationWithExamFacade;
import by.yurusova.entranceExam.facades.ExamAddingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Exam adding page controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
@RequestMapping("/admin")
public class ExamAddingController {

    @Autowired
    private ExamAddingFacade facade;

    @Autowired
    private AdminOperationWithExamFacade operationWithExamFacade;

    /**
     * Method shows exam adding page.
     *
     * @return exam adding page.
     */
    @RequestMapping(value = "addExam", method = RequestMethod.GET)
    public ModelAndView showAddingPage() {
        return facade.createModelAndView();
    }

    /**
     * Method adds exam.
     *
     * @param teacherID    the id of examiner.
     * @param subjectID    the id of subject.
     * @param specialityID the id of speciality.
     * @return exam list page.
     */
    @RequestMapping(value = "addExam", method = RequestMethod.POST)
    public ModelAndView addExam(@ModelAttribute("teacher") final String teacherID,
                                @ModelAttribute("subject") final String subjectID,
                                @ModelAttribute("speciality") final String specialityID) {
        facade.addExam(teacherID, subjectID, specialityID);
        return operationWithExamFacade.createExamListPage();
    }
}
