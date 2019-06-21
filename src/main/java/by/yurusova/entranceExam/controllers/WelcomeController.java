package by.yurusova.entranceExam.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Welcome page controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class WelcomeController {
    /**
     * Method shows welcome page.
     *
     * @return welcome page.
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView showWelcome() {
        ModelAndView mav = new ModelAndView("/welcome.jsp");
        return mav;
    }
}
