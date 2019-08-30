package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.facades.InformationPageCreationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Locale;

/**
 * Student page controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
@RequestMapping("/account")
public class StudentPageController {

    @Autowired
    private InformationPageCreationFacade facade;

    /**
     * Method returns student page with student information(exams of student, full name, current grade).
     *
     * @param principal object with login user information.
     * @param locale    current locale.
     * @return student page.
     */
    @RequestMapping("studentPage")
    public ModelAndView showStudentPage(final Principal principal, final Locale locale) {
        return facade.createStudentPage(principal, locale);
    }

}
