package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.ExamConverter;
import by.yurusova.entranceExam.converters.StudentConverterForRate;
import by.yurusova.entranceExam.converters.TeacherConverter;
import by.yurusova.entranceExam.dto.ExamDTO;
import by.yurusova.entranceExam.dto.StudentDTO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Teacher;
import by.yurusova.entranceExam.entities.User;
import by.yurusova.entranceExam.services.interfaces.ExamService;
import by.yurusova.entranceExam.services.interfaces.GradeService;
import by.yurusova.entranceExam.services.interfaces.UserService;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

    private UserService userService;

    private StudentConverterForRate studentConverter;

    private ExamConverter examConverter;

    private TeacherConverter teacherConverter;

    private GradeService gradeService;

    private MessageSourceAccessor messageSource;

    /**
     * Method creates ModelAndView for student page.
     * gets student information by login of user that bind with it,
     * converter it to studentDTO,
     * sets on page message for student depends on it status,
     * calculate total grade of student for all exams,
     * and sets it, it's exams(converted too) and total grade to modelAndView.
     *
     * @param principal object with user information.
     * @param locale    current locale.
     * @return the ModelAndView.
     */
    @Transactional
    public ModelAndView createStudentPage(final Principal principal, final Locale locale) {
        ModelAndView modelAndView = new ModelAndView("/studentPage.jsp");
        User user = userService.findByLogin(principal.getName());
        StudentDTO student = studentConverter.convert(user.getStudent());
        student.setGrade(user.getStudent().getTotalGrade());
        modelAndView.addObject("student", student);
        Map<ExamDTO, Integer> examsAndGrades = new HashMap<>();
        for (Exam exam : examService.findByStudent(student.getId())) {
            examsAndGrades.put(examConverter.convert(exam), gradeService.findByExamAndStudent(exam.getId(), student.getId()));
        }
        String message = "";
        Object[] args = new Object[]{};
        switch (user.getStudent().getStatus()) {
            case NEW_STUDENT:
                message = messageSource.getMessage("studentPage.message.haveNoExams", locale);
                break;
            case PASS_EXAMS:
                message = messageSource.getMessage("studentPage.message.examinationInProgress", locale);
                break;
            case ENTER:
                message = messageSource.getMessage("studentPage.message.entered", locale);
                break;
            case DID_NOT_ENTER:
                message = messageSource.getMessage("studentPage.message.didntEntered", locale);
                break;

        }
        modelAndView.addObject("message", message);
        modelAndView.addObject("examAndGradesMap", examsAndGrades);
        modelAndView.addObject("totalGrade", student.getGrade());
        return modelAndView;
    }


    /**
     * Method creates ModelAndView for teacher page,
     * gets teacher information by login of user that bind with this teacher,
     * converter it to teacherDTO,
     * and sets it ant it's exams(converted too),
     * if this exams still not graded, to modelAndView.
     *
     * @param principal object with user information.
     * @return the ModelAndView.
     */
    @Transactional
    public ModelAndView createTeacherPage(final Principal principal) {
        ModelAndView modelAndView = new ModelAndView("/teacherPage.jsp");
        User user = userService.findByLogin(principal.getName());
        Teacher teacher = user.getTeacher();
        modelAndView.addObject("teacher", teacherConverter.convert(teacher));
        List<ExamDTO> examDTOS = new ArrayList<>();
        for (Exam exam : teacher.getExams()) {
            if (!exam.isGraded()) {
                examDTOS.add(examConverter.convert(exam));
            }
        }
        modelAndView.addObject("examList", examDTOS);
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
     * Sets student converter.
     *
     * @param studentConverter converter to be set.
     */
    public void setStudentConverter(final StudentConverterForRate studentConverter) {
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

    /**
     * Sets grade service.
     *
     * @param gradeService service to be set.
     */
    public void setGradeService(final GradeService gradeService) {
        this.gradeService = gradeService;
    }

    /**
     * Sets MessageSourceAccessor.
     *
     * @param messageSource object to be set.
     */
    public void setMessageSource(final MessageSourceAccessor messageSource) {
        this.messageSource = messageSource;
    }
}
