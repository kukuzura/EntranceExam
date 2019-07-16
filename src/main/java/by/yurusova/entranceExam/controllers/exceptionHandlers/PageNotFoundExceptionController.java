package by.yurusova.entranceExam.controllers.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Page not found exception handler.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers.exceptionHandlers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@ControllerAdvice
public class PageNotFoundExceptionController {
    /**
     * Method return custom "404 page not fount" page.
     *
     * @return error page.
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound() {
        return "/errors/ErrorPage404.jsp";
    }
}
