package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.entities.Student;
import by.yurusova.entranceExam.entities.User;
import by.yurusova.entranceExam.services.interfaces.ExamService;
import by.yurusova.entranceExam.services.interfaces.GradeService;
import by.yurusova.entranceExam.services.interfaces.StudentService;
import by.yurusova.entranceExam.services.interfaces.UserService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

/**
 * Facade for user information page.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.facades
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class StudentInformationPageFacade {

    @Autowired
    private ExamService examService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    /**
     * Method creates ModelAndView for student page.
     *
     * @param principal object with user information.
     * @return the ModelAndView.
     */
    public ModelAndView createStudentPage(final Principal principal) {
        ModelAndView modelAndView = new ModelAndView("/studentPage.jsp");
        User user = userService.findByLogin(principal.getName());
        Student student = user.getStudent();
        modelAndView.addObject("student", student);
        modelAndView.addObject("examList", examService.findByStudent(student.getId()));
        return modelAndView;
    }

    /**
     * Sets grade service.
     *
     * @param gradeService service to be set.
     */
    public void setGradeService(final GradeService gradeService) {
        this.gradeService = gradeService;
    }

    /**
     * Sets user service.
     *
     * @param userService service to be set.
     */
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    /**
     * Sets student service.
     *
     * @param studentService service to be set.
     */
    public void setStudentService(final StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * Sets exam service.
     *
     * @param examService service to be set.
     */
    public void setExamService(final ExamService examService) {
        this.examService = examService;
    }
}
