package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.entity.Exam;
import by.yurusova.entranceExam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminExamListController {

    @Autowired
    private ExamService examService;

    @RequestMapping(value = "examList",method = RequestMethod.GET)
    ModelAndView showExamList(){
        ModelAndView mav=new ModelAndView("/examListPage.jsp");
        List<Exam> exams = examService.getAll();
        mav.addObject("examList",exams);
        return mav;
    }

    @RequestMapping(value = "/examDelete/{id}", method = RequestMethod.GET)
    public ModelAndView showDelete(@PathVariable("id") final long id) {
        examService.deleteExam(id);
        ModelAndView mav = new ModelAndView("/examListPage.jsp");
        List<Exam> exams = examService.getAll();
        mav.addObject("examList", exams);
        return mav;
    }
}
