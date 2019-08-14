package by.yurusova.entranceExam.controllers.exceptionHandlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Access Forbidden exception handler.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers.exceptionHandlers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
public class AccessForbiddenExceptionController {

    /**
     * Method return custom 403 page.
     *
     * @return the page.
     */
    @RequestMapping("/403")
    public String showErrorPage() {
        return "/errors/ErrorPage403.jsp";
    }
}

