package by.yurusova.entranceExam.dao;

import by.yurusova.entranceExam.entity.Exam;

import java.util.List;

/**
 * Interface defines base operations that can be performed with exam objects.
 *
 * @author Yuliya Yurusava <y.yurusava@sam-solurions.com>
 * @package by.yurusova.entranceExam.dao
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface ExamDAO {

    /**
     * Method gets exam by id.
     *
     * @param id the exam id.
     * @return exam with given id.
     */
    Exam findById(long id);

    /**
     * Method saves exam object to db.
     *
     * @param exam exam to be save.
     */
    void saveExam(Exam exam);

    /**
     * Method delete exam from db.
     *
     * @param exam exam to be delete.
     */
    void delete(Exam exam);

    /**
     * Method update exam in db.
     *
     * @param exam exam to be update.
     */
    void update(Exam exam);

    /**
     * Method gets all exams from db.
     *
     * @return list of exams.
     */
    List<Exam> getAll();

    /**
     * Method gets all exams with given speciality id.
     *
     * @param specialityID the speciality id.
     * @return list of exams.
     */
    List<Exam> findBySpeciality(long specialityID);

}
