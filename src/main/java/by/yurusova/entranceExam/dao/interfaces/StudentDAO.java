package by.yurusova.entranceExam.dao.interfaces;

import by.yurusova.entranceExam.entities.Student;

import java.util.List;

/**
 * Interface defines base operations that can be performed with student objects.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface StudentDAO {

    /**
     * Gets student by id.
     *
     * @param id student id.
     * @return the student.
     */
    Student findById(long id);

    /**
     * Saves given user to db.
     *
     * @param student student to be saved.
     * @return
     */
    Long saveStudent(Student student);

    /**
     * Delete user from db.
     *
     * @param student student to be deleted.
     */
    void delete(Student student);

    /**
     * Updates student in db.
     *
     * @param student student to be update.
     */
    void update(Student student);

    /**
     * Gets all student from db.
     *
     * @return lust of student.
     */
    List<Student> getAll();

    /**
     * Gets student by passport id.
     *
     * @param passportID the passport id.
     * @return user with given passport id.
     */
    Student findByPassportID(String passportID);

    /**
     * Method gets all students that register for exam with given id.
     *
     * @param examID exam id.
     * @return list of students.
     */
    List<Student> findByExamID(long examID);

    /**
     * Method gets all students that applied to speciality with given id.
     *
     * @param specialityID the specialty id.
     * @return list of students.
     */
    List<Student> findBySpecialityIDOrdered(final long specialityID);
}
