package by.yurusova.entranceExam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home page controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
public class HomeController {
    /**
     * Method shows home page.
     *
     * @return home page
     */
    @RequestMapping(value = "/")
    public String showHome() {
        return "/index.jsp";
    }
}
