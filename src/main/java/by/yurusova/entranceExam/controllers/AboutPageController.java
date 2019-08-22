package by.yurusova.entranceExam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for about page.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
public class AboutPageController {

    /**
     * Method returns about page.
     *
     * @return about page.
     */
    @RequestMapping("/about")
    public String showAboutPage() {
        return "/about.jsp";
    }
}
