package by.yurusova.entranceExam.controllers;


import by.yurusova.entranceExam.entity.Student;
import by.yurusova.entranceExam.entity.User;
import by.yurusova.entranceExam.service.RoleService;
import by.yurusova.entranceExam.service.StudentService;
import by.yurusova.entranceExam.service.UserService;
import by.yurusova.entranceExam.validator.StudentValidator;
import by.yurusova.entranceExam.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * Student Registration controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
public class RegistrationController {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private RoleService roleService;

    /**
     * Method sets validator to "user" model attribute.
     *
     * @param binder data binder
     */
    @InitBinder("user")
    protected void initUserBinder(final WebDataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    /**
     * Method sets validator to "student" model attribute.
     *
     * @param binder data binder
     */
    @InitBinder("student")
    protected void initStudentBinder(final WebDataBinder binder) {
        binder.setValidator(new StudentValidator());
    }

    /**
     * Method shows student registrtion page.
     *
     * @return student registration page.
     */
    @RequestMapping(value = "/studentRegister", method = RequestMethod.GET)
    public ModelAndView showStudentRegister() {
        ModelAndView mav = new ModelAndView("/studentRegistration.jsp");
        mav.addObject("user", new User());
        mav.addObject("student", new Student());
        return mav;
    }

    /**
     * Method returns welcome page if student information is correct,
     * or page with error messages if not.
     *
     * @param user                 the user to validate.
     * @param bindingResultUser    object that holds the result of user validation.
     * @param student              the student to validate.
     * @param bindingResultStudent object that holds the result of student validation.
     * @return welcome page.
     */
    @RequestMapping(value = "/studentRegister", method = RequestMethod.POST)
    public ModelAndView addStudent(
            @ModelAttribute("user") @Validated final User user, final BindingResult bindingResultUser,
            @ModelAttribute("student") @Validated final Student student, final BindingResult bindingResultStudent) {
        if (bindingResultStudent.hasErrors() || bindingResultUser.hasErrors()) {
            ModelAndView mav = new ModelAndView("/studentRegistration.jsp");
            mav.addObject("user", user);
            mav.addObject("student", student);
            return mav;
        }
        else {
            user.setRoles(Arrays.asList(roleService.findByName("ROLE_STUDENT")));
            userService.addUser(user);
            student.setUser(user);
            studentService.addStudent(student);
            return new ModelAndView("/welcome.jsp", "login", user.getLogin());
        }
    }
}


