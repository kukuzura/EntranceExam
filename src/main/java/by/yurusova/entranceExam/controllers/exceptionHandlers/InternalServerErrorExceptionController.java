package by.yurusova.entranceExam.controllers.exceptionHandlers;

import org.hibernate.NonUniqueResultException;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Internal Server Error exception handler.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers.exceptionHandlers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@ControllerAdvice
public class InternalServerErrorExceptionController {
    /**
     * Method return custom 500 page.
     *
     * @return the page.
     */
    @ExceptionHandler({NonUniqueResultException.class,
            NullPointerException.class,
            RequestRejectedException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String showErrorPage() {
        return "/errors/ErrorPage500.jsp";
    }
}
