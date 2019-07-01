package by.yurusova.entranceExam.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Login page controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(StudentRegistrationController.class);

    /**
     * Method shows login page.
     *
     * @param error the error that occurs when login and password dont't match.
     * @return login page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showRegister(@RequestParam(value = "error", required = false) final String error) {
        ModelAndView mav = new ModelAndView("/login.jsp");
        if (error != null) {
            mav.addObject("error", "Invalid username and password!");
        }
        return mav;
    }
}
