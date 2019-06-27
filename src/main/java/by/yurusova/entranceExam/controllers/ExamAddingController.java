package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.entity.Teacher;
import by.yurusova.entranceExam.service.ExamService;
import by.yurusova.entranceExam.service.SpecialityService;
import by.yurusova.entranceExam.service.SubjectService;
import by.yurusova.entranceExam.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class ExamAddingController {

    @Autowired
    ExamService examService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    SpecialityService specialityService;


    @RequestMapping(value = "addExam", method = RequestMethod.GET)
    ModelAndView showAddingPage() {
        ModelAndView mav = new ModelAndView("/addingExam.jsp");
        mav.addObject("teacherList", teacherService.getAll());
        mav.addObject("subjectList", subjectService.getAll());
        mav.addObject("specialityList", specialityService.getAll());
        return mav;
    }
}
