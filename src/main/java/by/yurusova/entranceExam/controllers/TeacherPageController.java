package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.facades.InformationPageCreationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Controller for teacher page.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
@RequestMapping("/account")
public class TeacherPageController {

    @Autowired
    private InformationPageCreationFacade pageCreationFacade;

    /**
     * Method shows teacher page.
     *
     * @param principal object that contains user information.
     * @return teacher page.
     */
    @RequestMapping("teacherPage")
    public ModelAndView showTeacherPage(final Principal principal) {
        return pageCreationFacade.createTeacherPage(principal);
    }


}
