package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.facades.InformationPageCreationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/account")
public class TeacherPageController {

    @Autowired
    private InformationPageCreationFacade pageCreationFacade;

    @RequestMapping("teacherPage")
    public ModelAndView showTeacherPage(Principal principal) {
        return pageCreationFacade.createTeacherPage(principal);
    }


}
