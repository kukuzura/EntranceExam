package by.yurusova.entranceExam.services.interfaces;

import by.yurusova.entranceExam.entities.Grade;

import java.util.List;

/**
 * Interface defines base grade services operations.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.services
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface GradeService {

    /**
     * Method saves grade to db.
     *
     * @param grade the grade to be save.
     */
    void saveGrade(Grade grade);

    /**
     * Method gets all grades fro db.
     *
     * @return list of grades.
     */
    List<Grade> getAll();

    /**
     * Method updates grade with of student with given id on exam with given id.
     *
     * @param grade     student grade
     * @param examID    exam id
     * @param studentID student id
     */
    void updateByExamAndStudent(long examID, long studentID, int grade);

    /**
     * Method gets student grade for exam with given id.
     *
     * @param examID    id of exam.
     * @param studentID id of student.
     * @return the grade.
     */
    int findByExamAndStudent(long examID, long studentID);
}