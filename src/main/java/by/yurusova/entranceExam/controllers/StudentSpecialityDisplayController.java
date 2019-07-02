package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.entity.Exam;
import by.yurusova.entranceExam.entity.Grade;
import by.yurusova.entranceExam.entity.Speciality;
import by.yurusova.entranceExam.entity.Student;
import by.yurusova.entranceExam.entity.User;
import by.yurusova.entranceExam.service.ExamService;
import by.yurusova.entranceExam.service.GradeService;
import by.yurusova.entranceExam.service.SpecialityService;
import by.yurusova.entranceExam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

/**
 * List of speciality page(for student) controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
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
    private UserService userService;

    /**
     * Method apply student to speciality with given id.
     *
     * @param id        the id.
     * @param principal object that contains username.
     * @return student information page.
     */
    @RequestMapping(value = "apply/{id}", method = RequestMethod.GET)
    String applyToSpeciality(@PathVariable("id") final long id, final Principal principal) {
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

    /**
     * Method shows speciality list.
     *
     * @return page with list of specialities.
     */
    @RequestMapping("specialityList")
    ModelAndView showSpecialityList() {
        ModelAndView mav = new ModelAndView("/specialityList.jsp");
        List<Speciality> specialities = specialityService.getAll();
        mav.addObject("specialityList", specialities);
        return mav;
    }
}
