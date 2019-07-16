package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.SpecialityConverter;
import by.yurusova.entranceExam.dto.SpecialityDTO;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Grade;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.entities.Student;
import by.yurusova.entranceExam.entities.User;
import by.yurusova.entranceExam.properties.ApplicationProperties;
import by.yurusova.entranceExam.services.interfaces.GradeService;
import by.yurusova.entranceExam.services.interfaces.SpecialityService;
import by.yurusova.entranceExam.services.interfaces.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Facade for student applying to speciality.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.facades
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class ApplyingToSpecialityFacade {

    private SpecialityService specialityService;

    private UserService userService;

    private GradeService gradeService;

    private SpecialityConverter specialityConverter;

    /**
     * Method register student that mapped with user fro principal
     * for all exams of speciality with given id.
     *
     * @param id        speciality id.
     * @param principal user information.
     */
    @Transactional
    public void applyToSpeciality(final long id, final Principal principal) {
        Speciality speciality = specialityService.findById(id);
        List<Exam> exams = speciality.getExams();
        User user = userService.findByLogin(principal.getName());
        Student student = user.getStudent();
        for (Exam exam : exams) {
            Grade grade = new Grade();
            grade.setExam(exam);
            grade.setStudent(student);
            gradeService.saveGrade(grade);
        }
    }

    /**
     * Method creates ModelAndView for SpecialityListPage,
     * converts speciality list to specialityDTO list,
     * and sets on model all specialties that have three exams.
     *
     * @return page with speciality list.
     */
    @Transactional
    public ModelAndView createSpecialityListPage() {
        ModelAndView mav = new ModelAndView("/specialityList.jsp");
        List<Speciality> specialities = specialityService.getAll();
        List<Speciality> removed = new ArrayList<>();

        for (Speciality speciality : specialities) {
            if (speciality.getExams().size() != Integer.valueOf(new ApplicationProperties().getExamAmount())) {
                removed.add(speciality);
            }
        }
        specialities.removeAll(removed);
        List<SpecialityDTO> specialityDTOS = new ArrayList<>();
        for (Speciality speciality : specialities) {
            specialityDTOS.add(specialityConverter.convert(speciality));
        }
        mav.addObject("specialityList", specialities);
        return mav;
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
     * Sets user service.
     *
     * @param userService service to be set.
     */
    public void setUserService(final UserService userService) {
        this.userService = userService;
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
     * Sets speciality converter.
     *
     * @param specialityConverter converter to be set.
     */
    public void setSpecialityConverter(final SpecialityConverter specialityConverter) {
        this.specialityConverter = specialityConverter;
    }


}
