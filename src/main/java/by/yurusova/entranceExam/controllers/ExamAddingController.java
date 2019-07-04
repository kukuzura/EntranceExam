package by.yurusova.entranceExam.controllers;

import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.entities.Subject;
import by.yurusova.entranceExam.entities.Teacher;
import by.yurusova.entranceExam.services.interfaces.ExamService;
import by.yurusova.entranceExam.services.interfaces.SpecialityService;
import by.yurusova.entranceExam.services.interfaces.SubjectService;
import by.yurusova.entranceExam.services.interfaces.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Exam adding page controller.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.controllers
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
@Controller
@RequestMapping("/admin")
public class ExamAddingController {

    @Autowired
    private ExamService examService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SpecialityService specialityService;

    /**
     * Method shows exam adding page.
     *
     * @return exam adding page.
     */
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

    /**
     * Method adds exam.
     *
     * @param teacherID    the id of examiner.
     * @param subjectID    the id of subject.
     * @param specialityID the id of speciality.
     * @return exam list page.
     */
    @RequestMapping(value = "addExam", method = RequestMethod.POST)
    String addExam(@ModelAttribute("teacher") final String teacherID,
                   @ModelAttribute("subject") final String subjectID,
                   @ModelAttribute("speciality") final String specialityID) {
        Teacher teacher = teacherService.findById(Long.valueOf(teacherID));
        Subject subject = subjectService.findById(Long.valueOf(subjectID));
        Speciality speciality = specialityService.findById(Long.valueOf(specialityID));
        Exam exam = new Exam();
        exam.setTeacher(teacher);
        exam.setSpeciality(speciality);
        exam.setSubject(subject);
        examService.saveExam(exam);
        return "redirect: /admin/examList";
    }
}
