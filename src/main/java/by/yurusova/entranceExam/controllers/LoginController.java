package by.yurusova.entranceExam.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Resource(name="userValidator")
    private Validator validator;

    private static final Logger logger = LoggerFactory
            .getLogger(RegistrationController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showRegister(@RequestParam(value = "error", required = false) String error, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("/login.jsp");
        if (error != null) {
            mav.addObject("error", "Invalid username and password!");
        }
        return mav;
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView showWelcome(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("/welcome.jsp");
        return mav;
    }
}
