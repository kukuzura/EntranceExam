package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.dto.TeacherDTO;
import by.yurusova.entranceExam.dto.UserDTO;
import by.yurusova.entranceExam.facades.RegistrationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Teacher Registration controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
public class TeacherRegistrationController {

    @Autowired
    private RegistrationFacade registrationFacade;

    @Autowired
    private Validator teacherValidator;

    @Autowired
    private Validator userValidator;

    /**
     * Method sets validators to "user" model attribute.
     *
     * @param binder the data binder.
     */
    @InitBinder("user")
    protected void initUserBinder(final WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    /**
     * Method sets validators to "teacher" model attribute.
     *
     * @param binder the data binder.
     */
    @InitBinder("teacher")
    protected void initTeacherBinder(final WebDataBinder binder) {
        binder.setValidator(teacherValidator);
    }

    /**
     * Method shows teacher registration page.
     *
     * @return teacher registration page
     */
    @RequestMapping(value = "/teacherRegister", method = RequestMethod.GET)
    public ModelAndView showTeacherRegisterPage() {
        return registrationFacade.createTeacherRegistrationPage();
    }

    /**
     * Method returns login page if teacher information correct,
     * or registration page if not.
     *
     * @param user                 user to be validate
     * @param bindingResultUser    result of user validation
     * @param teacher              teacher to be validate
     * @param bindingResultTeacher result of teacher validation
     * @param model                model
     * @param httpServletRequest   request information
     * @return the page
     */
    @RequestMapping(value = "/teacherRegister", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute("user") @Validated final UserDTO user,
                             final BindingResult bindingResultUser,
                             @ModelAttribute("teacher") @Validated final TeacherDTO teacher,
                             final BindingResult bindingResultTeacher,
                             final Model model,
                             final HttpServletRequest httpServletRequest) {
        if (bindingResultTeacher.hasErrors() || bindingResultUser.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("teacher", teacher);
            return "/teacherRegistration.jsp";
        }
        else {
            registrationFacade.registerTeacher(user, teacher);
            return "redirect: " + httpServletRequest.getContextPath() + "/login";
        }
    }
}
