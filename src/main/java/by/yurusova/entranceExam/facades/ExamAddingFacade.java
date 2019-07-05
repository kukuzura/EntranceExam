package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.entities.Subject;
import by.yurusova.entranceExam.entities.Teacher;
import by.yurusova.entranceExam.services.interfaces.ExamService;
import by.yurusova.entranceExam.services.interfaces.SpecialityService;
import by.yurusova.entranceExam.services.interfaces.SubjectService;
import by.yurusova.entranceExam.services.interfaces.TeacherService;
import org.springframework.web.servlet.ModelAndView;

/**
 * Facade for adding exam.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.facades
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class ExamAddingFacade {

    private ExamService examService;

    private TeacherService teacherService;

    private SubjectService subjectService;

    private SpecialityService specialityService;

    /**
     * Method adds exam to db.
     *
     * @param teacherID    id of examiner of current exam.
     * @param subjectID    id of subject of current exam.
     * @param specialityID id of speciality of current exam.
     */
    public void addExam(final String teacherID, final String subjectID, final String specialityID) {
        Teacher teacher = teacherService.findById(Long.valueOf(teacherID));
        Subject subject = subjectService.findById(Long.valueOf(subjectID));
        Speciality speciality = specialityService.findById(Long.valueOf(specialityID));
        Exam exam = new Exam();
        exam.setTeacher(teacher);
        exam.setSpeciality(speciality);
        exam.setSubject(subject);
        examService.saveExam(exam);
    }

    /**
     * Method creates ModelAndView ans adds
     * all required information on it.
     *
     * @return the ModelAndView.
     */
    public ModelAndView createModelAndView() {
        ModelAndView mav = new ModelAndView("/addingExam.jsp");
        mav.addObject("exam", new Exam());
        mav.addObject("teacherList", teacherService.getAll());
        mav.addObject("teacher", new Teacher());
        mav.addObject("subjectList", subjectService.getAll());
        mav.addObject("specialityList", specialityService.getAll());
        return mav;
    }

    /**
     * Sets exam service.
     *
     * @param examService the service to be set.
     */
    public void setExamService(final ExamService examService) {
        this.examService = examService;
    }

    /**
     * Sets teacher service.
     *
     * @param teacherService service to be set.
     */
    public void setTeacherService(final TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * Sets subject service.
     *
     * @param subjectService service to be set.
     */
    public void setSubjectService(final SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    /**
     * Sets speciality service.
     *
     * @param specialityService service to be set.
     */
    public void setSpecialityService(final SpecialityService specialityService) {
        this.specialityService = specialityService;
    }
}
