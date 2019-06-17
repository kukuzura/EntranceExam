package by.yurusova.entranceExam.controllers;


import by.yurusova.entranceExam.dao.RoleDAO;
import by.yurusova.entranceExam.entity.Student;
import by.yurusova.entranceExam.entity.User;
import by.yurusova.entranceExam.service.StudentService;
import by.yurusova.entranceExam.service.UserService;
import by.yurusova.entranceExam.validator.StudentValidator;
import by.yurusova.entranceExam.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @Autowired
    RoleDAO roleDAO;

    @Resource(name = "userValidator")
    Validator userValidator;

    @Resource(name="studentValidator")
    Validator studentValidator;

    private static final Logger logger = LoggerFactory
            .getLogger(RegistrationController.class);

    @InitBinder("user")
    protected void initUserBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidator());
    }

    @InitBinder("student")
    protected void initStudentBinder(WebDataBinder binder) {
        binder.setValidator(new StudentValidator());
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("/register.jsp");
        mav.addObject("user", new User());
        return mav;
    }


    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, @ModelAttribute("user") @Validated User user,
                                BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            logger.info("Returning register.jsp page");
            return new ModelAndView("/register.jsp", "user", user);
        } else {
            logger.info("Returning welcome.jsp page");
            user.setRoles(Arrays.asList(roleDAO.findByName("ROLE_STUDENT")));
            userService.addUser(user);
            return new ModelAndView("/welcome.jsp", "login", user.getLogin());
        }
    }

    @RequestMapping(value = "/studentRegister", method = RequestMethod.GET)
    public ModelAndView showStudentRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("/studentRegistration.jsp");
        mav.addObject("user", new User());
        mav.addObject("student", new Student());
        return mav;
    }

    @RequestMapping(value = "/studentRegisterProcess", method = RequestMethod.POST)
    public ModelAndView addStudent(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") @Validated User user, BindingResult bindingResultUser,
                                   @ModelAttribute("student") @Validated Student student, BindingResult bindingResultStudent) {
//        if ( bindingResultStudent.hasErrors() || bindingResultUser.hasErrors()) {
//            ModelAndView mav = new ModelAndView("/studentRegistration.jsp");
//            mav.addObject("user", user);
//            mav.addObject("student", student);
//            return mav;
//
////        } else {
            user.setRoles(Arrays.asList(roleDAO.findByName("ROLE_STUDENT")));
            userService.addUser(user);
            student.setUser(user);
            studentService.addStudent(student);
            return new ModelAndView("/welcome.jsp", "login", user.getLogin());
//        }
    }

}


