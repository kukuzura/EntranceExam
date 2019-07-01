package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.entity.Exam;
import by.yurusova.entranceExam.entity.Grade;
import by.yurusova.entranceExam.entity.Speciality;
import by.yurusova.entranceExam.entity.Student;
import by.yurusova.entranceExam.entity.User;
import by.yurusova.entranceExam.service.ExamService;
import by.yurusova.entranceExam.service.GradeService;
import by.yurusova.entranceExam.service.SpecialityService;
import by.yurusova.entranceExam.service.StudentService;
import by.yurusova.entranceExam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/account")
public class StudentSpecialityDisplayController {

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private ExamService examService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "apply/{id}", method = RequestMethod.GET)
    String applyToSpeciality(@PathVariable("id") final long id, Principal principal) {
        ModelAndView mav = new ModelAndView();
        Speciality speciality = specialityService.findById(id);
        List<Exam> exams = speciality.getExams();
        User user = userService.findByLogin(principal.getName());
        Student student = user.getStudent();
        Grade grade = new Grade();
        for (Exam exam : exams) {
            grade.setExam(exam);
            grade.setStudent(student);
            gradeService.saveGrade(grade);
        }
        return "/studentPage";
    }

    @RequestMapping("specialityList")
    ModelAndView showSpecialityList() {
        ModelAndView mav = new ModelAndView("/specialityList.jsp");
        List<Speciality> specialities = specialityService.getAll();
        mav.addObject("specialityList", specialities);
        return mav;
    }


}
