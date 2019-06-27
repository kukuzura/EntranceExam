package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.entity.Exam;
import by.yurusova.entranceExam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminExamListController {

    @Autowired
    ExamService examService;

    @RequestMapping("examList")
    ModelAndView showExamList(){
        ModelAndView mav=new ModelAndView("/examListPage.jsp");
        List<Exam> exams = examService.getAll();
        mav.addObject("examList",exams);
        return mav;
    }
}
