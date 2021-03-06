package by.yurusova.entranceExam.services.interfaces;

import by.yurusova.entranceExam.entities.Student;

import java.util.List;

/**
 * Interface defines base student services operations.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface StudentService {

    /**
     * Save student to db.
     *
     * @param student student to be saved.
     */
    void addStudent(Student student);


    /**
     * Delete student from db.
     *
     * @param id password id of deletes user.
     */
    void deleteStudent(long id);


    /**
     * Update user in db.
     *
     * @param student student to be update.
     */
    void editStudent(Student student);


    /**
     * Gets all users from db.
     *
     * @return list of users.
     */
    List<Student> getAll();


    /**
     * Gets user by id.
     *
     * @param id id of the user.
     * @return the user.
     */
    Student findById(long id);

    /**
     * Gets student by passport id.
     *
     * @param passportID the passport id.
     * @return student with given passport id.
     */
    Student findByPassportID(String passportID);

    /**
     * Gets all student that register foe exam with given id.
     *
     * @param examID exam id.
     * @return list of students.
     */
    List<Student> findByExamID(long examID);

    /**
     * Method counts total grade of student by his id.
     *
     * @param studentID the id.
     * @return total grade.
     */
    int getTotalGradeByID(long studentID);

    /**
     * Gets all student that applied to speciality with given id.
     *
     * @param specialityID speciality id.
     * @return list of students.
     */
    List<Student> findBySpecialityIDOrdered(long specialityID);
}

