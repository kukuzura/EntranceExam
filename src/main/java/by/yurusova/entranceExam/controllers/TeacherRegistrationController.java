package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.entity.Teacher;
import by.yurusova.entranceExam.entity.User;
import by.yurusova.entranceExam.service.RoleService;
import by.yurusova.entranceExam.service.TeacherService;
import by.yurusova.entranceExam.service.UserService;
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

import java.util.Arrays;

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
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private Validator teacherValidator;

    @Autowired
    private Validator userValidator;

    @InitBinder("user")
    protected void initUserBinder(final WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

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
        ModelAndView mav = new ModelAndView("/teacherRegistration.jsp");
        mav.addObject("user", new User());
        mav.addObject("teacher", new Teacher());
        return mav;
    }

    /**
     * Method returns login page if teacher information correct,
     * or registration page if not.
     *
     * @param user user to be validate
     * @param bindingResultUser result of user validation
     * @param teacher
     * @param bindingResultTeacher
     * @param model
     * @return
     */
    @RequestMapping(value = "/teacherRegister", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute("user") @Validated final User user, BindingResult bindingResultUser,
                             @ModelAttribute("teacher") @Validated final Teacher teacher, BindingResult bindingResultTeacher,
                             final Model model) {
        if (bindingResultTeacher.hasErrors() || bindingResultUser.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("teacher", teacher);
            return "/teacherRegistration.jsp";
        }
        else {
            user.setRoles(Arrays.asList(roleService.findByName("ROLE_TEACHER")));
            userService.addUser(user);
            teacher.setUser(user);
            teacherService.addTeacher(teacher);
            return "redirect:/login";
        }
    }
}
