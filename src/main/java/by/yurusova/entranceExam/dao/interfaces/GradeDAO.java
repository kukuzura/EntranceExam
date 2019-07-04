package by.yurusova.entranceExam.dao.interfaces;

import by.yurusova.entranceExam.entities.Grade;

import java.util.List;

/**
 * Interface defines base operations that can be performed with grade objects.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface GradeDAO {

    /**
     * Method gets all grades with given student id.
     *
     * @param studentId the given studentID.
     * @return list of grades.
     */
    List<Grade> findGradesByStudentId(long studentId);

    /**
     * Method saves grade to db.
     *
     * @param grade grade to be save.
     */
    void saveGrade(Grade grade);

    /**
     * Method gets all grades.
     *
     * @return list of grades.
     */
    List<Grade> getAll();
}
