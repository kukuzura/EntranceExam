package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.exceptions.ResourseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PageNotFoundExceptionController {
    @ExceptionHandler(ResourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound() {
        return "/ErrorPage404.jsp";
    }
}
