package by.yurusova.entranceExam.facades;

import by.yurusova.entranceExam.entities.Exam;
import by.yurusova.entranceExam.entities.Speciality;
import by.yurusova.entranceExam.entities.Student;
import by.yurusova.entranceExam.entities.StudentStatus;
import by.yurusova.entranceExam.properties.ApplicationProperties;
import by.yurusova.entranceExam.services.interfaces.SpecialityService;
import by.yurusova.entranceExam.services.interfaces.StudentService;

import java.util.List;

/**
 * Facade for calculation of entering grade.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.facades
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public class CalculationOfEnteringGradeFacade {

    private StudentService studentService;

    private SpecialityService specialityService;

    private ApplicationProperties applicationProperties;

    /**
     * Method checks are all exams of given specialty already graded.
     *
     * @param speciality speciality to check exams.
     * @return true if al exams graded, false otherwise.
     */
    public boolean isAllExamsGrated(final Speciality speciality) {
        for (Exam exam : speciality.getExams()) {
            if (!exam.isGraded()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method calculate entering grade of given speciality
     * and updates it information in database.
     * Students that gave enough grade gets status ENTERED,
     * DID_NOT_ENTER otherwise.
     * Entering grade is grade of tenth student
     * from list that ordered by total student grade.
     *
     * @param speciality speciality to calculate grade.
     */
    public void calculateAndSetEnteringGrade(final Speciality speciality) {
        List<Student> enteredStudents = studentService.findBySpecialityIDOrdered(speciality.getId());
        speciality.setEnteringGrade(enteredStudents
                        .get(Integer.valueOf(applicationProperties.getStudentAmount()) - 1)
                        .getTotalGrade());
        for (Student student : enteredStudents) {
            student.setStatus(StudentStatus.ENTER);
            studentService.editStudent(student);
        }
        List<Student> students = studentService.getAll();
        students.removeAll(enteredStudents);
        for (Student student : students) {
            student.setStatus(StudentStatus.DID_NOT_ENTER);
            studentService.editStudent(student);
        }
        specialityService.update(speciality);
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
     * Method sets speciality service.
     *
     * @param specialityService service to be set.
     */
    public void setSpecialityService(final SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    /**
     * Sets object that contains project constants.
     *
     * @param applicationProperties the object.
     */
    public void setApplicationProperties(final ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

}
