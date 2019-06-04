package by.yurusova.entranceExam.controller;


import by.yurusova.entranceExam.entity.User;
import by.yurusova.entranceExam.service.UserService;
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

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @Autowired
    @Qualifier("userValidator")
    Validator validator;

    Logger logger = LoggerFactory
            .getLogger(RegistrationController.class);

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("/register.jsp");
        mav.addObject("user", new User());
        return mav;
    }


    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request,@ModelAttribute("user") @Validated User user,
                                BindingResult bindingResult,HttpServletResponse response) {
        if(bindingResult.hasErrors()){
            logger.info("Returning register.jsp page");
            return new ModelAndView("/register.jsp", "user", user);
        }
        else {
            logger.info("Returning welcome.jsp page");
            userService.addUser(user);
            return new ModelAndView("/welcome.jsp", "login", user.getLogin());
        }
    }


}


