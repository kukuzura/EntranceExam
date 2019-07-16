package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.SpecialityConverter;
import by.yurusova.entranceExam.converters.SubjectConverter;
import by.yurusova.entranceExam.converters.TeacherConverter;
import by.yurusova.entranceExam.dto.ExamDTO;
import by.yurusova.entranceExam.dto.SpecialityDTO;
import by.yurusova.entranceExam.dto.SubjectDTO;
import by.yurusova.entranceExam.dto.TeacherDTO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.entities.Subject;
import by.yurusova.entranceExam.entities.Teacher;
import by.yurusova.entranceExam.services.interfaces.ExamService;
import by.yurusova.entranceExam.services.interfaces.SpecialityService;
import by.yurusova.entranceExam.services.interfaces.SubjectService;
import by.yurusova.entranceExam.services.interfaces.TeacherService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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

    private SpecialityConverter specialityConverter;

    private TeacherConverter teacherConverter;

    private SubjectConverter subjectConverter;

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
        mav.addObject("exam", new ExamDTO());
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        for (Teacher teacher : teacherService.getAll()) {
            teacherDTOList.add(teacherConverter.convert(teacher));
        }
        mav.addObject("teacherList", teacherDTOList);
        mav.addObject("teacher", new TeacherDTO());
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        mav.addObject("subjectList", subjectDTOS);
        for (Subject subject : subjectService.getAll()) {
            subjectDTOS.add(subjectConverter.convert(subject));
        }
        List<SpecialityDTO> specialityDTOS = new ArrayList<>();
        for (Speciality speciality : specialityService.getAll()) {
            specialityDTOS.add(specialityConverter.convert(speciality));
        }
        mav.addObject("specialityList", specialityDTOS);
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

    /**
     * Sets speciality converter.
     *
     * @param specialityConverter converter to be set.
     */
    public void setSpecialityConverter(final SpecialityConverter specialityConverter) {
        this.specialityConverter = specialityConverter;
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
     * Sets subject converter.
     *
     * @param subjectConverter converter to be set.
     */
    public void setSubjectConverter(final SubjectConverter subjectConverter) {
        this.subjectConverter = subjectConverter;
    }
}
