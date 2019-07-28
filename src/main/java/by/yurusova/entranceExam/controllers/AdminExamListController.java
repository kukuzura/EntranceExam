package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.facades.AdminOperationWithExamFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    private AdminOperationWithExamFacade facade;

    /**
     * Method shows the list of exams.
     *
     * @return page with list of exams.
     */
    @RequestMapping(value = "examList", method = RequestMethod.GET)
    ModelAndView showExamList() {
        return facade.createExamListPage();
    }

    /**
     * Method delete exam with given id.
     *
     * @param id the id.
     * @return page with list of exams.
     */
    @RequestMapping(value = "/examDelete/{id}", method = RequestMethod.GET)
    public ModelAndView showDelete(@PathVariable("id") final long id) {
        facade.deleteExam(id);
        return facade.createExamListPage();
    }

    /**
     * Sets admin operation with exam facade.
     *
     * @param facade facade to be set.
     */
    public void setFacade(final AdminOperationWithExamFacade facade) {
        this.facade = facade;
    }
}
