package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.ExamConverter;
import by.yurusova.entranceExam.converters.StudentConverter;
import by.yurusova.entranceExam.converters.TeacherConverter;
import by.yurusova.entranceExam.entities.Student;
import by.yurusova.entranceExam.entities.Teacher;
import by.yurusova.entranceExam.entities.User;
import by.yurusova.entranceExam.services.interfaces.ExamService;
import by.yurusova.entranceExam.services.interfaces.StudentService;
import by.yurusova.entranceExam.services.interfaces.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Facade for student and teacher information page.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.facades
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class InformationPageCreationFacade {

    private ExamService examService;

    private StudentService studentService;

    private UserService userService;

    private StudentConverter studentConverter;

    private ExamConverter examConverter;

    private TeacherConverter teacherConverter;

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
        modelAndView.addObject("totalGrade", studentService.getTotalGradeByID(student.getId()));
        return modelAndView;
    }


    /**
     * Method creates ModelAndView for teacher page.
     *
     * @param principal object with user information.
     * @return the ModelAndView.
     */
    @Transactional
    public ModelAndView createTeacherPage(final Principal principal) {
        ModelAndView modelAndView = new ModelAndView("/teacherPage.jsp");
        User user = userService.findByLogin(principal.getName());
        Teacher teacher = user.getTeacher();
        modelAndView.addObject("teacher", teacher);
        modelAndView.addObject("examList", teacher.getExams());
        return modelAndView;
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
     * Sets exam service.
     *
     * @param examService service to be set.
     */
    public void setExamService(final ExamService examService) {
        this.examService = examService;
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
     * Sets student converter.
     *
     * @param studentConverter converter to be set.
     */
    public void setStudentConverter(final StudentConverter studentConverter) {
        this.studentConverter = studentConverter;
    }

    /**
     * Sets exam converter.
     *
     * @param examConverter converter to be set.
     */
    public void setExamConverter(final ExamConverter examConverter) {
        this.examConverter = examConverter;
    }

    /**
     * Sets teacher converter.
     *
     * @param teacherConverter converter to be set.
     */
    public void setTeacherConverter(final TeacherConverter teacherConverter) {
        this.teacherConverter = teacherConverter;
    }
}
