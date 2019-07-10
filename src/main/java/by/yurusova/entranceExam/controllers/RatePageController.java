package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.dao.StudentForm;
import by.yurusova.entranceExam.facades.RateFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class RatePageController {

    @Autowired
    RateFacade rateFacade;

    @RequestMapping(value = "rate/{id}", method = RequestMethod.GET)
    public ModelAndView showRatePage(@PathVariable("id") final long examId) {
        return rateFacade.showRatePage(examId);
    }

    @RequestMapping(value = "rate/{id}", method = RequestMethod.POST)
    public String rateStudents(@PathVariable("id") final long examId, @ModelAttribute("studentForm") StudentForm studentForm) {
        rateFacade.rateStudents(studentForm.getStudents(), examId);
        return "/account/teacherPage.jsp";
    }
}
