package by.yurusova.entranceExam.controllers;


import by.yurusova.entranceExam.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    Validator validator;

    private static final Logger logger = LoggerFactory
            .getLogger(RegistrationController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("/login.jsp");
        return mav;
    }
}
