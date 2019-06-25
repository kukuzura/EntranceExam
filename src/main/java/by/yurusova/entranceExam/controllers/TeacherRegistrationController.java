package by.yurusova.entranceExam.controllers;


import by.yurusova.entranceExam.entity.Teacher;
import by.yurusova.entranceExam.entity.User;
import by.yurusova.entranceExam.service.RoleService;
import by.yurusova.entranceExam.service.TeacherService;
import by.yurusova.entranceExam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/teacherRegister", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute("user") final User user,
                             @ModelAttribute("teacher") final Teacher teacher,
                             final Model model) {
        user.setRoles(Arrays.asList(roleService.findByName("ROLE_TEACHER")));
        userService.addUser(user);
        teacher.setUser(user);
        teacherService.addTeacher(teacher);
        return "redirect:/login";
    }
}
