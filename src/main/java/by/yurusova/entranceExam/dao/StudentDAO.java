package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.Student;

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
     * @param passportId student id.
     * @return the student.
     */
    Student findById(String passportId);

    /**
     * Saves given user to db.
     *
     * @param student student to be saved.
     */
    void saveStudent(Student student);

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
}
