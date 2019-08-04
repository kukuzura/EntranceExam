package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.converters.StudentConverterForRate;
import by.yurusova.entranceExam.dto.StudentDTO;
import by.yurusova.entranceExam.dto.StudentForm;
import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Student;
import by.yurusova.entranceExam.entities.StudentStatus;
import by.yurusova.entranceExam.services.interfaces.ExamService;
import by.yurusova.entranceExam.services.interfaces.GradeService;
import by.yurusova.entranceExam.services.interfaces.StudentService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade for student grading.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.facades
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class RateFacade {

    private GradeService gradeService;

    private StudentService studentService;

    private ExamService examService;

    private StudentConverterForRate studentConverterForRate;

    private CalculationOfEnteringGradeFacade calculationOfEnteringGradeFacade;

    /**
     * Method creates ModelAndView for rate page,
     * finds all students that register to this exam,
     * converts the into StudentDTOs sets list of StudentsDTO in
     * studentForm and pass to ModelAndView.
     *
     * @param examID id of exam.
     * @return modelAndView.
     */
    public ModelAndView showRatePage(final long examID) {
        ModelAndView modelAndView = new ModelAndView("/ratePage.jsp");
        modelAndView.addObject("examID", examID);
        modelAndView.addObject("student", new StudentDTO());
        List<Student> students = studentService.findByExamID(examID);
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            studentDTOS.add(studentConverterForRate.convert(student));
        }
        StudentForm studentForm = new StudentForm();
        studentForm.setStudents(studentDTOS);
        modelAndView.addObject("studentForm", studentForm);
        return modelAndView;
    }

    /**
     * Method updates student grades in db,
     * for all students that register for exams with id examID,
     * and sets isGraded flag to true.
     *
     * @param studentDTOS list of student with grades.
     * @param examID      exam id.
     */
    public void rateStudents(final List<StudentDTO> studentDTOS, final long examID) {
        Exam exam = examService.findByID(examID);
        exam.setGraded(true);
        for (StudentDTO studentDTO : studentDTOS) {
            Student student = studentService.findById(studentDTO.getId());
            student.setStatus(StudentStatus.PASS_EXAMS);
            student.setTotalGrade(studentDTO.getGrade() + student.getTotalGrade());
            gradeService.updateByExamAndStudent(examID, studentDTO.getId(), studentDTO.getGrade());
            studentService.editStudent(student);
        }
        examService.update(exam);
        if (calculationOfEnteringGradeFacade.isAllExamsGrated(exam.getSpeciality())) {
            calculationOfEnteringGradeFacade.calculateAndSetEnteringGrade(exam.getSpeciality());
        }
    }

    /**
     * Method sets grade service.
     *
     * @param gradeService service to be set.
     */
    public void setGradeService(final GradeService gradeService) {
        this.gradeService = gradeService;
    }

    /**
     * Method sets student service.
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

    /**
     * Sets studentConverter.
     *
     * @param studentConverterForRate converter to be set.
     */
    public void setStudentConverterForRate(final StudentConverterForRate studentConverterForRate) {
        this.studentConverterForRate = studentConverterForRate;
    }

    /**
     * Sets facade for calculating entering grade.
     *
     * @param calculationOfEnteringGradeFacade facade to be set.
     */
    public void setCalculationOfEnteringGradeFacade(final CalculationOfEnteringGradeFacade calculationOfEnteringGradeFacade) {
        this.calculationOfEnteringGradeFacade = calculationOfEnteringGradeFacade;
    }
}
