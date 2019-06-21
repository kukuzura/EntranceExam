package by.yurusova.entranceExam.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(RegistrationController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showRegister(@RequestParam(value = "error", required = false) String error) {
        ModelAndView mav = new ModelAndView("/login.jsp");
        if (error != null) {
            mav.addObject("error", "Invalid username and password!");
        }
        return mav;
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView showWelcome() {
        ModelAndView mav = new ModelAndView("/welcome.jsp");
        return mav;
    }
}
