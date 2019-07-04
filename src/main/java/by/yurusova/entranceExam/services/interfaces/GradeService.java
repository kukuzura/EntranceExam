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
}
