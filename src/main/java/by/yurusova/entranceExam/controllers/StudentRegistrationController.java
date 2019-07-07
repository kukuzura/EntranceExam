package by.yurusova.entranceExam.controllers;


import by.yurusova.entranceExam.dto.StudentDTO;
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

import javax.annotation.Resource;

/**
 * Student Registration controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
public class StudentRegistrationController {

    @Autowired
    private RegistrationFacade registrationFacade;

    @Resource(name = "userValidator")
    private Validator userValidator;

    @Resource(name = "studentValidator")
    private Validator studentValidator;

    /**
     * Method sets validators to "user" model attribute.
     *
     * @param binder data binder
     */
    @InitBinder("user")
    protected void initUserBinder(final WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    /**
     * Method sets validators to "student" model attribute.
     *
     * @param binder data binder
     */
    @InitBinder("student")
    protected void initStudentBinder(final WebDataBinder binder) {
        binder.setValidator(studentValidator);
    }

    /**
     * Method shows student registration page.
     *
     * @return student registration page.
     */
    @RequestMapping(value = "/studentRegister", method = RequestMethod.GET)
    public ModelAndView showStudentRegister() {
        return registrationFacade.createStudentRegistrationPage();
    }

    /**
     * Method returns login page if student information is correct,
     * or page with error messages if not.
     *
     * @param user                 the user to validate.
     * @param bindingResultUser    object that holds the result of user validation.
     * @param student              the student to validate.
     * @param bindingResultStudent object that holds the result of student validation.
     * @param model                the model
     * @return welcome page.
     */
    @RequestMapping(value = "/studentRegister", method = RequestMethod.POST)
    public String addStudent(
            @ModelAttribute("user") @Validated final UserDTO user, final BindingResult bindingResultUser,
            @ModelAttribute("student") @Validated final StudentDTO student, final BindingResult bindingResultStudent,
            final Model model) {
        if (bindingResultStudent.hasErrors() || bindingResultUser.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("student", student);
            return "/studentRegistration.jsp";
        }
        else {
            registrationFacade.registerStudent(user, student);
            return "redirect:/login";
        }
    }
}


