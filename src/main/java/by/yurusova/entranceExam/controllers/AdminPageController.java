package by.yurusova.entranceExam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Admin page controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
public class AdminPageController {

    /**
     * Method shows admin page.
     *
     * @return admin page.
     */
    @RequestMapping("/admin/adminPage")
    public String showAdminPage() {
        return "/adminPage.jsp";
    }
}
