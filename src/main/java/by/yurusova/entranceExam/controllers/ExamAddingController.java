package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.entity.Exam;
import by.yurusova.entranceExam.entity.Speciality;
import by.yurusova.entranceExam.entity.Subject;
import by.yurusova.entranceExam.entity.Teacher;
import by.yurusova.entranceExam.service.ExamService;
import by.yurusova.entranceExam.service.SpecialityService;
import by.yurusova.entranceExam.service.SubjectService;
import by.yurusova.entranceExam.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
        mav.addObject("exam", new Exam());
        mav.addObject("teacherList", teacherService.getAll());
        mav.addObject("teacher", new Teacher());
        mav.addObject("subjectList", subjectService.getAll());
        mav.addObject("specialityList", specialityService.getAll());
        return mav;
    }

    @RequestMapping(value = "addExam", method = RequestMethod.POST)
    String addExam(HttpServletRequest request,
                   @ModelAttribute("teacher") String teacher_id,
                   @ModelAttribute("subject") String subject_id,
                   @ModelAttribute("speciality") String speciality_id,
                   BindingResult bindingResult,
                   Model model) {
        Teacher teacher = teacherService.findById(Long.valueOf(teacher_id));
        Subject subject = subjectService.findById(Long.valueOf(subject_id));
        Speciality speciality = specialityService.findById(Long.valueOf(speciality_id));
        Exam exam = new Exam();
        exam.setTeacher(teacher);
        exam.setSpeciality(speciality);
        exam.setSubject(subject);
        examService.saveExam(exam);
        return "redirect: /admin/examList";
    }
}
